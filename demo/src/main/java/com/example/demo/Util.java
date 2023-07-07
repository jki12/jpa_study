package com.example.demo;

import com.example.demo.article.Article;

import java.util.Random;

public class Util {
    private static final Random RAND = new Random();
    private static final StringBuilder SB = new StringBuilder();

    private Util() {
    }

    private String generate() {
        SB.setLength(0);

        for (int i = 0; i < RAND.nextInt(30); ++i) SB.append((char) (RAND.nextInt(65, 122 + 1)));

        if (RAND.nextBoolean()) return "fixed";

        return SB.toString();
    }

    private Article generateArticle() {
        return new Article(generate(), generate());
    }
}
