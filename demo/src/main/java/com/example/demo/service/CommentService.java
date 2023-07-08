package com.example.demo.service;

import com.example.demo.Util;
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
        try {

            repo.save(comment);

            return true;

        }
        catch (Exception e) {

            // error handling.

            return false;

        }
    }

    public ArrayList<Comment> findByArticleId(Long id) {

        return new ArrayList<>(repo.findByArticleId(id)); // check to empty res case.
    }

    public ArrayList<Comment> findAll() {
        return Util.iterableToArrayList(repo.findAll());
    }
}
