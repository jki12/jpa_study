package com.example.demo.repo;

import com.example.demo.comment.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CommentRepo extends CrudRepository<Comment, Long> {
    @Query("select c from Comment c where c.articleId = :articleId")
    List<Comment> findByArticleId(@Param("articleId") Long articleId);
}
