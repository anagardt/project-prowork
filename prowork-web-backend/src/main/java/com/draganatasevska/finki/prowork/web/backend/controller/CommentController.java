package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.Comment;
import com.draganatasevska.finki.prowork.web.backend.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;

@Api(value = ApiSwaggerConstants.COMMENT_API_VALUE)
@RestController
@RequestMapping(value = "/api/comment", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = ApiSwaggerConstants.ALL_COMMENTS_BY_ISSUE_OPERATION_VALUE,
        notes= ApiSwaggerConstants.ALL_COMMENTS_BY_ISSUE_OPERATION_NOTE,
        response= Iterable.class)
    @GetMapping(value = "/allByIssueId", produces = "application/json")
    public Iterable<Comment> getAllCommentsByIssue(@RequestParam long issueId) {
        return commentService.getAllCommentsForIssue(issueId);
    }

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

    @ApiOperation(value = ApiSwaggerConstants.DELETE_COMMENT_OPERATION_VALUE,
            notes= ApiSwaggerConstants.DELETE_COMMENT_OPERATION_NOTE,
            response= Comment.class)
    @PostMapping(value = "/delete",  produces = "application/json")
    public long deleteComment(@RequestParam long commentId) {
        return this.commentService.deleteComment(commentId);
    }
}
