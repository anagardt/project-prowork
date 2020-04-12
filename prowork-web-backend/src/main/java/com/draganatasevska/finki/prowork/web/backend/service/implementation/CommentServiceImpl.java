package com.draganatasevska.finki.prowork.web.backend.service.implementation;

import com.draganatasevska.finki.prowork.web.backend.model.*;
import com.draganatasevska.finki.prowork.web.backend.repository.*;
import com.draganatasevska.finki.prowork.web.backend.service.AccessService;
import com.draganatasevska.finki.prowork.web.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final AccessService accessService;
    private final CommentDao commentDao;
    private final IssueDao issueDao;
    private final UserDao userDao;

    @Override
    public Iterable<Comment> getAllCommentsForIssue(long issueId) {
        Issue issue = issueDao.findById(issueId).get();
        return commentDao.findAllByIssue(issue);
    }

    @Override
    public Comment addComment(Comment comment, String jwtToken) {
        String username = this.accessService.getUsernameFromJwtToken(jwtToken);
        User user = userDao.findByUsername(username);
        comment.setCommentedBy(user);
        return commentDao.save(comment);
    }

    @Override
    public long deleteComment(long commendId) {
        return commentDao.deleteByCommentId(commendId);
    }
}
