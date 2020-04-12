package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import com.draganatasevska.finki.prowork.web.backend.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 *  Controller for the comment model API requests.
 */
@Api(value = ApiSwaggerConstants.COMMENT_API_VALUE)
@RestController
@RequestMapping(value = "/api/comment", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * Returns a list of all comments associated with the issue that
     * corresponds to the provided issueId.
     * @param issueId the issueId that uniquely identifies the issue.
     *
     * @return {@link Iterable<Comment>} the list of all comments.
     */
    @ApiOperation(value = ApiSwaggerConstants.ALL_COMMENTS_BY_ISSUE_OPERATION_VALUE,
        notes= ApiSwaggerConstants.ALL_COMMENTS_BY_ISSUE_OPERATION_NOTE,
        response= Iterable.class)
    @GetMapping(value = "/allByIssueId", produces = "application/json")
    public Iterable<Comment> getAllCommentsByIssue(@RequestParam long issueId) {
        return commentService.getAllCommentsForIssue(issueId);
    }

    /**
     * Adds new comment for an issue according to the Comment model provided.
     * @param newComment the new Comment model.
     * @param httpServletRequest used for user access check.
     *
     * @return {@link Comment} the newly created Comment.
     */
    @ApiOperation(value = ApiSwaggerConstants.ADD_COMMENT_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ADD_COMMENT_OPERATION_NOTE,
            response= Comment.class)
    @PostMapping(value = "/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = "application/json")
    public Comment addComment(@ModelAttribute Comment newComment, HttpServletRequest httpServletRequest) {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        return commentService.addComment(newComment, jwtToken);
    }

    /**
     * Deletes a comment associated with the provided comment id.
     * @param commentId the commentId that uniquely identifies the comment.
     *
     * @return the commentId of the deleted comment.
     */
    @ApiOperation(value = ApiSwaggerConstants.DELETE_COMMENT_OPERATION_VALUE,
            notes= ApiSwaggerConstants.DELETE_COMMENT_OPERATION_NOTE,
            response= Comment.class)
    @PostMapping(value = "/delete",  produces = "application/json")
    public long deleteComment(@RequestParam long commentId) {
        return this.commentService.deleteComment(commentId);
    }
}
