package com.example.demo.service;

import com.example.demo.Util;
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

    public boolean isExist(Long id) {
        return !findById(id).equals(Article.EMPTY);
    }

    public boolean save(Article article) {
        try {
            repo.save(article);

            return true;
        }
        catch (Exception e) {

            return false;
        }
    }

    public ArrayList<Article> findAll() {
        return Util.iterableToArrayList(repo.findAll());
    }

    public Article findById(Long id) {
        return repo.findById(id).orElseGet(() -> Article.EMPTY);
    }

    public Article update(Long id, ArticleDto articleDto) {
        var res = findById(id);

        if (res.equals(Article.EMPTY)) return null;

        res.update(articleDto);

        return res;
    }

    public void deleteArticle(Long id) {
        repo.deleteById(id);
    }
}
