package com.maia.publication.entity;

import com.maia.publication.domain.Comment;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
public class PublicationEntity {

    @Id
    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments;
}
