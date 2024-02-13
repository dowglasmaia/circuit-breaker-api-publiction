package com.maia.publication.repository.entity;

import com.maia.publication.domain.Comment;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collation = "publications")
public class PublicationEntity {

    @Id
    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments = new ArrayList<>();
}
