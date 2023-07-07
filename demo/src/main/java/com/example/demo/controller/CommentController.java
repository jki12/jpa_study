package com.example.demo.controller;

import com.example.demo.article.ArticleDto;
import com.example.demo.comment.Comment;
import com.example.demo.repo.CommentRepo;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @Autowired private CommentService service;

    @GetMapping("comments")
    public Object getComments() {
        return service.findAll();
    }


    @PostMapping("/articles/{article-id}/comments")
    public Object postComment(@PathVariable("article-id") Long articleId, @RequestBody String s) {
        var comment = new Comment(articleId, s);

        service.save(comment);

        return comment;
    }

    @GetMapping("/articles/{article-id}/comments")
    public Object getArticleComments(@PathVariable("article-id") Long articleId) {

        return service.findByArticleId(articleId);
    }
}
