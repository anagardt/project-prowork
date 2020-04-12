package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {
    Iterable<Comment> findAllByIssue(Issue issue);

    @Transactional
    long deleteByCommentId(long commentId);
}
