package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

/**
 * Service used to provide the issue functionality.
 */
@Service
public interface IssueService {
    /**
     * Creates a new issue according to the Issue model provided.
     * @param issue the new Issue model.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Issue} the newly created Issue
     */
    Issue createIssue(Issue issue, String jwtToken);

    /**
     * Changes the status code of the issue with the provided issueId.
     * @param issueId the issueId by which the issue is uniquely identified.
     * @param statusCode the new status code.
     *
     * @return {@link Issue} the updated issue.
     * @throws ServletException
     */
    Issue changeStatus(long issueId, int statusCode) throws ServletException;

    /**
     * Changes the assignee of the issue with the provided issueId.
     * @param issueId the issueId by which the issue is uniquely identified.
     * @param username the username by which
     * the new assignee is uniquely identified.
     *
     * @return {@link Issue} the updated issue.
     * @throws ServletException
     */
    Issue changeAssignee(long issueId, String username) throws ServletException;

    /**
     * Changes the project of the issue with the provided issueId.
     * @param issueId the issueId by which the issue is uniquely identified.
     * @param projectId the projectId by which
     * the new project is uniquely identified.
     *
     * @return {@link Issue} the updated issue.
     * @throws ServletException
     */
    Issue changeProject(long issueId, long projectId) throws ServletException;

    /**
     * Gets all issues for the user provided.
     * (assign to, reviewed by or created by)
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Iterable<Issue>} the list of all issues.
     */
    Iterable<Issue> getAllIssuesForUser(String jwtToken);

    /**
     * Gets only the issues assigned to the user provided.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Iterable<Issue>} the list of all issues.
     */
    Iterable<Issue> getAssignedToIssuesForUser(String jwtToken);

    /**
     * Gets only the issues created by the user provided.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Iterable<Issue>} the list of all issues.
     */
    Iterable<Issue> getCreatedByIssuesForUser(String jwtToken);

    /**
     * Gets only the issues reviewed by the user provided.
     * @param jwtToken the jwtToken by which the user
     * is uniquely identified
     *
     * @return {@link Iterable<Issue>} the list of all issues.
     */
    Iterable<Issue> getReviewedByIssuesForUser(String jwtToken);
}
