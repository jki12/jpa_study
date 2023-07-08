package com.example.demo.controller;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleDto;
import com.example.demo.service.ArticleService;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired private ArticleService articleService;
    @Autowired private CommentService commentService;


    private Article getById(Long id) {
        return articleService.findById(id);
    }

    @PostMapping("/articles")
    public boolean postArticle(@RequestBody ArticleDto articleDto) {
        return articleService.save(new Article(articleDto));
    }

    @GetMapping("/articles/{article-id}")
    public Article getArticleById(@PathVariable("article-id") Long articleId) {
        var res = getById(articleId);

        // res == empty.

        res.setComments(commentService.findByArticleId(articleId));

        return res;
    }

    @DeleteMapping("/articles/{article-id}")
    public void deleteArticle(@PathVariable("article-id") Long articleId) {
        articleService.deleteArticle(articleId);
    }

    @GetMapping("/articles")
    public Object getArticles() {
        var res = articleService.findAll();

        for (var article : res) article.setComments(commentService.findByArticleId(article.getId()));

        return res;
    }


    @PatchMapping("/articles/{article-id}")
    public Object patchArticle(@PathVariable("article-id") Long articleId, @RequestBody ArticleDto articleDto) {
        var article = getById(articleId);

        if (article == null) return null;

        articleService.update(articleId, articleDto);

        return article;
    }
}
