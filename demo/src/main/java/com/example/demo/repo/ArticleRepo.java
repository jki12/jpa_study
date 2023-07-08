package com.example.demo.repo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ArticleRepo extends CrudRepository<Article, Long> {
}
