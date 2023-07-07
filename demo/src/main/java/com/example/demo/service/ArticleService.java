package com.example.demo.service;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleDto;
import com.example.demo.comment.Comment;
import com.example.demo.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    @Autowired private ArticleRepo repo;

    public boolean save(Article article) {
        return repo.save(article);
    }

    public ArrayList<Article> findAll() {
        return repo.findAllArticles().get();
    }

    public Article findById(Long id) {
        return repo.findById(id).orElseGet(() -> null);
    }

    public void update(Long id, ArticleDto articleDto) {
        repo.update(id, articleDto);
    }

    public void removeArticle(Long id) {
        repo.remove(id);
    }
}
