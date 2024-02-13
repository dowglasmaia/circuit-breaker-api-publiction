package com.maia.publication.service;

import com.maia.publication.domain.Publication;
import com.maia.publication.repository.PublicationRepository;
import com.maia.publication.mapper.PublicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository repository;

    @Autowired
    private PublicationMapper publicationMapper;

    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        repository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = repository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }

    public Publication findById(String id) {
        return repository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(RuntimeException::new);
    }
}
