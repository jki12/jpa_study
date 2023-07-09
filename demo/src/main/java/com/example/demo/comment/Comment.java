package com.example.demo.comment;

import com.example.demo.model.BaseEntity;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class Comment extends BaseEntity {
    @NonNull private Long articleId;
    @NonNull private String comment;
}
