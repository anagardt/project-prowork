package com.draganatasevska.finki.prowork.web.backend.service.implementation;

import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import com.draganatasevska.finki.prowork.web.backend.repository.IssueDao;
import com.draganatasevska.finki.prowork.web.backend.repository.ProjectDao;
import com.draganatasevska.finki.prowork.web.backend.repository.UserDao;
import com.draganatasevska.finki.prowork.web.backend.service.AccessService;
import com.draganatasevska.finki.prowork.web.backend.service.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import java.util.Date;

/**
 * The implementation of @{@link IssueService}
 */
@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {

    private final AccessService accessService;
    private final IssueDao issueDao;
    private final UserDao userDao;
    private final ProjectDao projectDao;

    @Override
    public Issue createIssue(Issue issue, String jwtToken) {
        issue.setStatus(Issue.issueStatus.TO_DO);
        String username = accessService.getUsernameFromJwtToken(jwtToken);
        User createBy = userDao.findByUsername(username);
        issue.setCreatedBy(createBy);
        issue.setDateCreated(new Date());
        return issueDao.save(issue);
    }

    @Override
    public Issue changeStatus(long issueId, int statusCode) throws ServletException {
        Issue issue = issueDao.findById(issueId).get();
        switch (statusCode) {
            case 0: {
                issue.setStatus(Issue.issueStatus.TO_DO);
                break;
            }
            case 1: {
                issue.setStatus(Issue.issueStatus.IN_PROGRESS);
                break;
            }
            case 2: {
                issue.setStatus(Issue.issueStatus.DONE);
                break;
            }
            default: {
                throw new ServletException("Invalid Status Code");
            }
        }
        return issueDao.save(issue);
    }

    @Override
    public Issue changeAssignee(long issueId, String username) {
        Issue issue = issueDao.findById(issueId).get();
        User user = userDao.findByUsername(username);
        issue.setAssignedTo(user);
        return issueDao.save(issue);
    }

    @Override
    public Issue changeProject(long issueId,long projectId) {
        Issue issue = issueDao.findById(issueId).get();
        Project project = projectDao.findById(projectId).get();
        issue.setProject(project);
        return issueDao.save(issue);
    }

    @Override
    public Iterable<Issue> getAllIssuesForUser(String jwtToken) {
        String username = accessService.getUsernameFromJwtToken(jwtToken);
        User user = userDao.findByUsername(username);
        return issueDao.findDistinctByAssignedToOrCreatedByOrReviewedBy(user, user, user);
    }

    @Override
    public Iterable<Issue> getAssignedToIssuesForUser(String jwtToken) {
        String username = accessService.getUsernameFromJwtToken(jwtToken);
        User user = userDao.findByUsername(username);
        return issueDao.findAllByAssignedTo(user);
    }

    @Override
    public Iterable<Issue> getCreatedByIssuesForUser(String jwtToken) {
        String username = accessService.getUsernameFromJwtToken(jwtToken);
        User user = userDao.findByUsername(username);
        return issueDao.findAllByCreatedBy(user);
    }

    @Override
    public Iterable<Issue> getReviewedByIssuesForUser(String jwtToken) {
        String username = accessService.getUsernameFromJwtToken(jwtToken);
        User user = userDao.findByUsername(username);
        return issueDao.findAllByReviewedBy(user);
    }
}
