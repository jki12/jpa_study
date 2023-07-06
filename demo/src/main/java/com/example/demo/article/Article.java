package com.example.demo.article;

import com.example.demo.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.Nullable;

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
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String mainText;
    // private ArrayList<Comment> comments = new ArrayList<>();

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
}
