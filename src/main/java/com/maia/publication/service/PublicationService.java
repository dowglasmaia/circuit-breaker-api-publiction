package com.maia.publication.service;

import com.maia.publication.domain.Publication;
import com.maia.publication.mapper.PublicationMapper;
import com.maia.publication.repository.PublicationRepository;
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
    private final CommentsService commentsService;

    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        repository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = repository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }


    public Publication findById(String id) {
        Publication publication = repository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(RuntimeException::new);

        var comments = commentsService.findById(id);

        publication.setComments(comments);

        return publication;
    }

}
