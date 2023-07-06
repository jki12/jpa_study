package com.example.demo.repo;

import com.example.demo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CommentRepo {
    @PersistenceContext
    private EntityManager em;

    public Comment save(Comment comment) {

        em.persist(comment);

        return comment;
    }

    public List<Comment> findByArticleId(Long id) {

        String ql = "select c from Comment c where c.articleId = :id";


        return em.createQuery(ql).setParameter("id", id).getResultList();

    }
}
