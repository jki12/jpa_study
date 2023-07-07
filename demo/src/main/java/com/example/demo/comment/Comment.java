package com.example.demo.comment;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Getter
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long articleId;
    private final OffsetDateTime createdDate;
    private String comment;

    public Comment() {
        createdDate = OffsetDateTime.now();
    }

    public Comment(Long articleId, String comment) {
        this();

        this.articleId = articleId;
        this.comment = comment;
    }
}
