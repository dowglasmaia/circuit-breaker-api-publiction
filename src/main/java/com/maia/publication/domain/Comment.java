package com.maia.publication.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String author;
    private String text;
}
