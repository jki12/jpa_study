package com.example.demo.article;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class ArticleDto {
    @NonNull private String title;
    @NonNull private String mainText;
}
