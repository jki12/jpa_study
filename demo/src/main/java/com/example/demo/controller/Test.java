package com.example.demo.controller;

import com.example.demo.Comment;
import com.example.demo.article.Article;
import com.example.demo.article.ArticleDto;
import com.example.demo.repo.ArticleRepo;
import com.example.demo.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Test {
    @Autowired private ArticleRepo repo;
    @Autowired private CommentRepo cRepo;

    private String generate() {
        var sb = new StringBuilder();
        var rand = new Random();

        for (int i = 0; i < rand.nextInt(30); ++i) sb.append((char) (rand.nextInt(65, 122 + 1)));

        if (rand.nextBoolean()) return "fixed";

        return sb.toString();
    }

    private Article generateArticle() {

        return new Article(generate(), generate());
    }

    @PostMapping("/articles/new")
    public void uploadArticle(@RequestBody ArticleDto articleDto) {

        // servie

        repo.save(new Article(articleDto));

        // return true;

    }

    @PostMapping("/articles/")
    public void addComment() {

        cRepo.save(new Comment(2L, "a"));

        // servie

        // repo.save(new Article(articleDto));

        // return true;

    }


    @GetMapping("/test")
    public Object test() {
        // see sql.
        // for (int i = 0; i < 10; ++i) cRepo.save(generate());

        return cRepo.findByArticleId(2L);
    }
}
