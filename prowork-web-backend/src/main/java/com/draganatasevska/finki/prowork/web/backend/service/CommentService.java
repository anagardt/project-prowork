package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Iterable<Comment> getAllCommentsForIssue(long issueId);

    Comment addComment(Comment comment, String jwtToken);

    long deleteComment(long commendId);
}
