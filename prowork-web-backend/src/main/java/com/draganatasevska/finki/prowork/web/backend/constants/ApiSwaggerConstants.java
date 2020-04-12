package com.draganatasevska.finki.prowork.web.backend.constants;

import com.draganatasevska.finki.prowork.web.backend.controller.*;

/**
 *  Constants used when documenting Api with Swagger
 */
public final class ApiSwaggerConstants {
    /**
     * Prevent instantiation
     */
    private ApiSwaggerConstants() {

    }

    /**
     * The title for the Swagger api
     */
    public static final String SWAGGER_API_TITLE = "ProWork Application Rest Api";

    /**
     * The description for the Swagger api
     */
    public static final String SWAGGER_API_DESCRIPTION = "Documentation and clear overview of the ProWork Rest Api";

    /**
     * The description for {@link IssueController}
     */
    public static final String ISSUE_API_VALUE = "ProWork Rest Api for Issue controller";

    /**
     * The description for createIssue in {@link IssueController}
     */
    public static final String CREATE_ISSUE_OPERATION_VALUE = "Creates new issue.";

    /**
     * The note for createIssue in {@link IssueController}
     */
    public static final String CREATE_ISSUE_OPERATION_NOTE =
            "Creates new issue according to the provided issue model.";

    /**
     * The description for changeStatus in {@link IssueController}
     */
    public static final String CHANGE_STATUS_OPERATION_VALUE = "Change issue's status.";

    /**
     * The note for changeStatus in {@link IssueController}
     */
    public static final String CHANGE_STATUS_OPERATION_NOTE =
            "Change the status of the issue with the provided issue id.";

    /**
     * The description for changeAssignee in {@link IssueController}
     */
    public static final String CHANGE_ASSIGNEE_OPERATION_VALUE = "Change issue's assignee.";

    /**
     * The note for changeAssignee in {@link IssueController}
     */
    public static final String CHANGE_ASSIGNEE_OPERATION_NOTE =
            "Change the assignee of the issue with the provided issue id.";

    /**
     * The description for changeProject in {@link IssueController}
     */
    public static final String CHANGE_PROJECT_OPERATION_VALUE = "Change issue's project.";

    /**
     * The note for changeProject in {@link IssueController}
     */
    public static final String CHANGE_PROJECT_OPERATION_NOTE =
            "Change the project of the issue with the provided issue id.";

    /**
     * The description for getAllIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_ISSUES_OPERATION_VALUE = "Gets all issues for the provided user.";

    /**
     * The note for getAllIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_ISSUES_OPERATION_NOTE =
            "Gets all issues associated with the provided user.";

    /**
     * The description for getCreatedByIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_CREATED_ISSUES_OPERATION_VALUE = "Gets all issues created by the provided user.";

    /**
     * The note for getCreatedByIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_CREATED_ISSUES_OPERATION_NOTE =
            "Gets all issues that are created from the provided user.";

    /**
     * The description for getReviewedByIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_REVIEWED_ISSUES_OPERATION_VALUE = "Gets all issues reviewed by the provided user.";

    /**
     * The note for getReviewedByIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_REVIEWED_ISSUES_OPERATION_NOTE =
            "Gets all issues that are reviewed from the provided user.";

    /**
     * The description for getAssignedToIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_ASSIGNED_ISSUES_OPERATION_VALUE = "Gets all issues assigned by the provided user.";

    /**
     * The note for getAssignedToIssuesForUser in {@link IssueController}
     */
    public static final String ALL_USER_ASSIGNED_ISSUES_OPERATION_NOTE =
            "Gets all issues that are assigned from the provided user.";

    /**
     * The description for {@link CommentController}
     */
    public static final String COMMENT_API_VALUE = "ProWork Rest Api for Comment controller";

    /**
     * The description for getAllCommentsByIssue in {@link CommentController}
     */
    public static final String ALL_COMMENTS_BY_ISSUE_OPERATION_VALUE = "Gets all comments for the provided issue.";

    /**
     * The note for getAllCommentsByIssue in {@link CommentController}
     */
    public static final String ALL_COMMENTS_BY_ISSUE_OPERATION_NOTE = "Gets all comments for the provided issue.";

    /**
     * The description for addComment in {@link CommentController}
     */
    public static final String ADD_COMMENT_OPERATION_VALUE = "Adds a comment.";

    /**
     * The note for addComment in {@link CommentController}
     */
    public static final String ADD_COMMENT_OPERATION_NOTE = "Adds a comment associated with corresponding issue and user.";

    /**
     * The description for deleteComment in {@link CommentController}
     */
    public static final String DELETE_COMMENT_OPERATION_VALUE = "Deletes a comment.";

    /**
     * The note for deleteComment in {@link CommentController}
     */
    public static final String DELETE_COMMENT_OPERATION_NOTE = "Deletes a comment associated with corresponding issue and user.";

    /**
     * The description for {@link ProjectController}
     */
    public static final String PROJECT_API_VALUE = "ProWork Rest Api for Project controller";

    /**
     * The description for createProject in {@link ProjectController}
     */
    public static final String CREATE_PROJECT_OPERATION_VALUE = "Creates new project.";

    /**
     * The note for createProject in {@link ProjectController}
     */
    public static final String CREATE_PROJECT_OPERATION_NOTE =
            "Creates new project according to the provided project model.";

    /**
     * The description for getAllProjects in {@link ProjectController}
     */
    public static final String ALL_PROJECTS_OPERATION_VALUE = "Gets all projects.";

    /**
     * The note for getAllProjects in {@link ProjectController}
     */
    public static final String ALL_PROJECTS_OPERATION_NOTE = "Gets all project";

    /**
     * The description for {@link UserController}
     */
    public static final String USER_API_VALUE = "ProWork Rest Api for User controller";

    /**
     * The description for getAllUsers in {@link UserController}
     */
    public static final String ALL_USERS_OPERATION_VALUE = "Gets all users.";

    /**
     * The note for getAllUsers in {@link UserController}
     */
    public static final String ALL_USERS_OPERATION_NOTE = "Gets all users.";

    /**
     * The description for {@link AccessController}
     */
    public static final String ACCESS_API_VALUE = "ProWork Rest Api for Access controller";

    /**
     * The description for registerUser in {@link AccessController}
     */
    public static final String REGISTER_USER_OPERATION_VALUE = "Register user.";

    /**
     * The note for registerUser in {@link AccessController}
     */
    public static final String REGISTER_USER_OPERATION_NOTE =
            "Register user provided according to the provided user model.";

    /**
     * The description for loginUser in {@link AccessController}
     */
    public static final String LOGIN_USER_OPERATION_VALUE = "Login user.";

    /**
     * The note for loginUser in {@link AccessController}
     */
    public static final String LOGIN_USER_OPERATION_NOTE =
            "Login user provided according to the provided user model.";

    /**
     * The description for passwordReset in {@link AccessController}
     */
    public static final String PASSWORD_RESET_OPERATION_VALUE = "Reset user password request.";

    /**
     * The note for passwordReset in {@link AccessController}
     */
    public static final String PASSWORD_RESET_OPERATION_NOTE =
            "Creates token and sends an email for resetting the user password.";

    /**
     * The description for passwordResetSave in {@link AccessController}
     */
    public static final String PASSWORD_RESET_SAVE_OPERATION_VALUE = "Save the new user password.";

    /**
     * The note for passwordResetSave in {@link AccessController}
     */
    public static final String PASSWORD_RESET_SAVE_OPERATION_NOTE =
            "Saves the new password for the provided user.";


}
