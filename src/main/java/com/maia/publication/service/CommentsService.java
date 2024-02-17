package com.maia.publication.service;

import com.maia.publication.client.CommentClient;
import com.maia.publication.domain.Comment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentsService {

    private final CommentClient commentClient;

    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsFallback")
    public List<Comment> findById(String id) {
        return commentClient.getComments(id);
    }


    private List<Comment> getCommentsFallback(String id, Throwable cause) {
        log.warn("[WARN] Fallback with id {}", id);
        return List.of();
    }

}
