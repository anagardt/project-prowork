package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueDao extends CrudRepository<Issue, Long> {
    Iterable<Issue> findDistinctByAssignedToOrCreatedByOrReviewedBy(User assignedTo, User createdBy, User reviewedBy);

    Iterable<Issue> findAllByCreatedBy(User createdBy);

    Iterable<Issue> findAllByReviewedBy(User reviewedBy);

    Iterable<Issue> findAllByAssignedTo(User assignedTo);

    Iterable<Issue> findAllByProject(Project project);

    Iterable<Issue> findAllByStatus(Issue.issueStatus issueStatus);

    Iterable<Issue> findAllByType(Issue.issueType issueType);
}
