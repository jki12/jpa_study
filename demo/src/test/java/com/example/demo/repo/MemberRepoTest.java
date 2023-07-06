package com.example.demo.repo;

import com.example.demo.article.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberRepoTest {
    @Autowired private ArticleRepo repo;

    private String generate() {
        var sb = new StringBuilder();
        var rand = new Random();

        for (int i = 0; i < rand.nextInt(256); ++i) sb.append((char) (rand.nextInt(65, 122 + 1)));

        if (rand.nextBoolean()) return "name";

        return sb.toString();
    }

    private Article generateArticle() {

        return new Article(generate(), generate());
    }

    @Test
    void Test() {

        var article = generateArticle();

        repo.save(article);

        for (int i = 0; i < 10; ++i) repo.save(generateArticle());


        repo.save(article);
    }

}