package com.example.demo.article;

import com.example.demo.comment.Comment;
import com.example.demo.model.BaseEntity;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@RequiredArgsConstructor
public class Article extends BaseEntity {
    public static final Article EMPTY = new Article("Search result not found.", "des...");

    private OffsetDateTime modifiedDate;
    @Column(nullable = false)
    @NonNull private String title;
    @Column(nullable = false)
    @NonNull private String mainText;

    @Transient
    @Setter private ArrayList<Comment> comments = new ArrayList<>();

    public Article(ArticleDto articleDto) {
        this.title = articleDto.getTitle();
        this.mainText = articleDto.getMainText();
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
