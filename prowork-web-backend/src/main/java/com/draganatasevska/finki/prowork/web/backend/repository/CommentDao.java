package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Dao used for comment data.
 */
@Repository
public interface CommentDao extends CrudRepository<Comment, Long> {
    /**
     * Find all comments for the provided issue.
     * @param issue {@link Issue} the issue.
     *
     * @return {@link Iterable<Comment>} list of all comments.
     */
    Iterable<Comment> findAllByIssue(Issue issue);

    /**
     * Delete the commend with the provided commentId.
     * @param commentId the commentId by which the
     * comment is uniquely identified.
     *
     * @return the commentId of the deleted comment.
     */
    @Transactional
    long deleteByCommentId(long commentId);
}
