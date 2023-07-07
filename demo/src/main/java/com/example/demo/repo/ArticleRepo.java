package com.example.demo.repo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ArticleRepo {
    @PersistenceContext
    private EntityManager em;

    public boolean save(Article article) {
        try {
            em.persist(article);
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public Optional<ArrayList<Article>> findAllArticles() {
        ArrayList<Article> res = new ArrayList<>();

        try {
            // 값이 하나여도 정상 작동하는지 확인.
            res.addAll(em.createQuery("select a from Article a", Article.class).getResultList());

            return Optional.of(res);
        } catch (Exception e) {

            return Optional.of(res);
        }
    }

    public Optional<Article> findById(Long id) {
        String jql = "select a from Article a where a.id = :id";

        try {
            Article res = em.createQuery(jql, Article.class).setParameter("id", id).getSingleResult();

            return Optional.ofNullable(res);
        } catch (Exception e) {

            return Optional.empty();
        }
    }

    public void update(Long id, ArticleDto articleDto) {
        var article = findById(id);

        if (article.isEmpty()) return;

        article.get().update(articleDto); // test.
    }

    public void remove(Long id) {
        var res = findById(id);

        if (res.isEmpty()) return;

        em.remove(res.get());
    }
}
