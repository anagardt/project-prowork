package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

@Service
public interface IssueService {
    Issue createIssue(Issue issue, String jwtToken);

    Issue changeStatus(long issueId, int statusCode) throws ServletException;

    Issue changeAssignee(long issueId, String username) throws ServletException;

    Issue changeProject(long issueId, long projectId) throws ServletException;

    Iterable<Issue> getAllIssuesForProject(long projectId);

    Iterable<Issue> getAllIssuesForUser(String jwtToken);

    Iterable<Issue> getAssignedToIssuesForUser(String jwtToken);

    Iterable<Issue> getCreatedByIssuesForUser(String jwtToken);

    Iterable<Issue> getReviewedByIssuesForUser(String jwtToken);
}
