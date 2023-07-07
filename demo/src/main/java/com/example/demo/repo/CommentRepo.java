package com.example.demo.repo;

import com.example.demo.comment.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class CommentRepo {
    @PersistenceContext
    private EntityManager em;

    public boolean save(Comment comment) {

        try {
            em.persist(comment);
        } catch (Exception e) {
            // handling

            e.printStackTrace();

            return false;
        }

        return true;
    }

    public Optional<ArrayList<Comment>> findByArticleId(Long id) {
        final String ql = "select c from Comment c where c.articleId = :id";
        var res = new ArrayList<Comment>();

        try {
            res.addAll(em.createQuery(ql).setParameter("id", id).getResultList());

            return Optional.of(res);
        } catch (Exception e) {
            return Optional.of(res);
        }
    }

    public ArrayList<Comment> findAll() {
        ArrayList<Comment> res = new ArrayList<>();

        res.addAll(em.createQuery("select c from Comment c", Comment.class).getResultList());

        return res;
    }
}
