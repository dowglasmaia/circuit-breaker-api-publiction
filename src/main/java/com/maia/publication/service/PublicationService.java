package com.maia.publication.service;

import com.maia.publication.client.CommentClient;
import com.maia.publication.domain.Publication;
import com.maia.publication.exceptions.FallbackException;
import com.maia.publication.mapper.PublicationMapper;
import com.maia.publication.repository.PublicationRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PublicationService {

    private final PublicationRepository repository;
    private final PublicationMapper publicationMapper;
    private final CommentClient commentClient;

    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        repository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = repository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }

    @CircuitBreaker(name = "comments", fallbackMethod = "findByIdFallback")
    public Publication findById(String id) {
        Publication publication = repository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(RuntimeException::new);

        var comments = commentClient.getComments(id);

        publication.setComments(comments);

        return publication;
    }

    private Publication findByIdFallback(String id, Throwable cause) {
        log.warn("[WARN] Fallback with id {}", id);
        throw new FallbackException(cause);
    }
}
