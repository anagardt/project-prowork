package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import com.draganatasevska.finki.prowork.web.backend.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Dao used for issue data.
 */
@Repository
public interface IssueDao extends CrudRepository<Issue, Long> {
    /**
     * Find all Issues that are either assigned to user1,
     * created by user2 or reviewed by the provided user3.
     * @param assignedTo {@link User} that the issues are assigned to
     * @param createdBy {@link User} that the issues are created by
     * @param reviewedBy {@link User} that the issues are reviewed by
     *
     * @return {@link Iterable<Issue>} list of all issues.
     */
    Iterable<Issue> findDistinctByAssignedToOrCreatedByOrReviewedBy(User assignedTo, User createdBy, User reviewedBy);

    /**
     * Find all issues created by the provided user.
     * @param createdBy {@link User} the user.
     *
     * @return {@link Iterable<Issue>} list of all issues.
     */
    Iterable<Issue> findAllByCreatedBy(User createdBy);

    /**
     * Find all issues reviewed by the provided user.
     * @param reviewedBy {@link User} the user.
     *
     * @return {@link Iterable<Issue>} list of all issues.
     */
    Iterable<Issue> findAllByReviewedBy(User reviewedBy);

    /**
     * Find all issues assigned to the provided user.
     * @param assignedTo {@link User} the user.
     *
     * @return {@link Iterable<Issue>} list of all issues.
     */
    Iterable<Issue> findAllByAssignedTo(User assignedTo);

    /**
     * Find all issues that are part of the provided project.
     *
     * @param project {@link Project} the project.
     * @return {@link Iterable<Issue>} list of all issues.
     */
    Iterable<Issue> findAllByProject(Project project);
}
