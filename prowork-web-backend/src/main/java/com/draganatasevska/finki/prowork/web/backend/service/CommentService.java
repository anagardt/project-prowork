package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import org.springframework.stereotype.Service;

/**
 * Service used to provide the comment functionality.
 */
@Service
public interface CommentService {

    /**
     * Returns a list of all comments associated with the issue that
     * corresponds to the provided issueId.
     * @param issueId the issueId that uniquely identifies the issue.
     *
     * @return {@link Iterable<Comment>} the list of all comments.
     */
    Iterable<Comment> getAllCommentsForIssue(long issueId);

    /**
     * Adds new comment for an issue according to the Comment model provided.
     * @param comment the new Comment model.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Comment} the newly created Comment.
     */
    Comment addComment(Comment comment, String jwtToken);

    /**
     * Deletes a comment associated with the provided comment id.
     * @param commentId the commentId that uniquely identifies the comment.
     *
     * @return the commentId of the deleted comment.
     */
    long deleteComment(long commentId);
}
