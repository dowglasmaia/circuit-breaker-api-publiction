package com.maia.publication.service;

import com.maia.publication.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisService {

    private static final String KEY = "comment";

    private final RedisTemplate<String, Object> redisTemplate;

    public void save(List<Comment> comments, String id) {
        redisTemplate.opsForHash().put(KEY, id, comments);
    }

    public List<Comment> findById(String id) {
        return (List<Comment>) redisTemplate.opsForHash().get(KEY, id);
    }

}
