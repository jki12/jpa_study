package com.example.demo.repo;

import com.example.demo.article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ArticleRepo {
    @PersistenceContext
    private EntityManager em;

    public Article save(Article article) { // service에서 valid 체크.

        try {

            em.persist(article);

        } catch (Exception e) {

            em.getTransaction().rollback(); // need to test.
        }

        return article;
    }

    public List<Article> getByName() {
        String title = "name";

        return em.createQuery("select a from article where a.title = :title", Article.class).getResultList();

    }


}
