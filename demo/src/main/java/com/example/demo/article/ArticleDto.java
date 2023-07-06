package com.example.demo.article;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ArticleDto {
    private String title;
    private String mainText;

    public ArticleDto(String title, String mainText) {
        this.title = title;
        this.mainText = mainText;
    }
}
