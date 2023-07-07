package com.example.demo.service;

import com.example.demo.comment.Comment;
import com.example.demo.repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired private CommentRepo repo;

    public boolean save(Comment comment) {
        return repo.save(comment);
    }

    public ArrayList<Comment> findByArticleId(Long id) {
        assert (repo.findByArticleId(id).isPresent());

        return repo.findByArticleId(id).get();
    }

    public ArrayList<Comment> findAll() {
        return repo.findAll();
    }
}
