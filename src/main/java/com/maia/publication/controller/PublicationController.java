package com.maia.publication.controller;

import com.maia.publication.controller.request.PublicationRequest;
import com.maia.publication.domain.Publication;
import com.maia.publication.mapper.PublicationMapper;
import com.maia.publication.service.PublicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private PublicationMapper publicationMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody PublicationRequest request) {
        var publication = publicationMapper.toPublication(request);
        publicationService.insert(publication);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Publication> findAll() {
        return publicationService.findAll();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Publication findById(@PathVariable String id) {
        return publicationService.findById(id);
    }
}
