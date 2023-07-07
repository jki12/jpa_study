package com.example.demo.article;

import com.example.demo.comment.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@Entity
@Getter
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Column(name = "CREATED_DATE")
    @Column(nullable = false)
    private final OffsetDateTime createdDate;
    private OffsetDateTime modifiedDate;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String mainText;

    @Transient
    @Setter private ArrayList<Comment> comments = new ArrayList<>();

    protected Article() {
        createdDate = OffsetDateTime.now();
    }

    public Article(ArticleDto articleDto) {
        this(articleDto.getTitle(), articleDto.getMainText());
    }

    public Article(String title, String mainText) {
        this();

        this.title = title;
        this.mainText = mainText;
    }

    public boolean isModified() {
        return (modifiedDate != null);
    }

    public void update(ArticleDto articleDto) {
        modifiedDate = OffsetDateTime.now();

        this.title = articleDto.getTitle();
        this.mainText = articleDto.getMainText();
    }
}
