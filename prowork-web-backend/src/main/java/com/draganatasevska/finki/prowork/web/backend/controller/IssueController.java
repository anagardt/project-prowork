package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.Issue;
import com.draganatasevska.finki.prowork.web.backend.service.IssueService;
import com.draganatasevska.finki.prowork.web.backend.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Api(value = ApiSwaggerConstants.ISSUE_API_VALUE)
@RestController
@RequestMapping(value = "/api/issue", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class IssueController {

    private final IssueService issueService;

    @ApiOperation(value = ApiSwaggerConstants.CREATE_ISSUE_OPERATION_VALUE,
            notes= ApiSwaggerConstants.CREATE_ISSUE_OPERATION_NOTE,
            response= Issue.class)
    @PostMapping(value = "/new", produces = "application/json")
    public Issue createIssue(@ModelAttribute Issue newIssue, @RequestParam String dueDate, @RequestParam boolean dueDateSelected, HttpServletRequest httpServletRequest) throws ParseException {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = dueDateSelected ? format.parse(dueDate) : null;
        newIssue.setDateDue(date);
        if (dueDateSelected) {
            System.out.println(newIssue.getDateDue().toString());
        }
        return this.issueService.createIssue(newIssue, jwtToken);
    }

    @ApiOperation(value = ApiSwaggerConstants.CHANGE_STATUS_OPERATION_VALUE,
            notes= ApiSwaggerConstants.CHANGE_STATUS_OPERATION_NOTE,
            response= Issue.class)
    @PostMapping(value = "/changeStatus", produces = "application/json")
    public Issue changeStatus(@RequestParam long issueId, @RequestParam int statusCode) throws ServletException {
        return this.issueService.changeStatus(issueId, statusCode);
    }

    @ApiOperation(value = ApiSwaggerConstants.CHANGE_ASSIGNEE_OPERATION_VALUE,
            notes= ApiSwaggerConstants.CHANGE_ASSIGNEE_OPERATION_NOTE,
            response= Issue.class)
    @PostMapping(value = "/changeAssignee", produces = "application/json")
    public Issue changeAssignee(@RequestParam long issueId, @RequestParam String username) throws ServletException {
        return this.issueService.changeAssignee(issueId, username);
    }

    @ApiOperation(value = ApiSwaggerConstants.CHANGE_PROJECT_OPERATION_VALUE,
            notes= ApiSwaggerConstants.CHANGE_PROJECT_OPERATION_NOTE,
            response= Issue.class)
    @PostMapping(value = "/changeProject",  produces = "application/json")
    public Issue changeProject(@RequestParam long issueId, @RequestParam long projectId) throws ServletException {
        return this.issueService.changeProject(issueId, projectId);
    }

    @ApiOperation(value = ApiSwaggerConstants.ALL_USER_ISSUES_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_USER_ISSUES_OPERATION_NOTE,
            response= Iterable.class, produces = "application/json")
    @GetMapping(value = "/all")
    public Iterable<Issue> getAllIssuesForUser(HttpServletRequest httpServletRequest) {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        return issueService.getAllIssuesForUser(jwtToken);
    }

    @ApiOperation(value = ApiSwaggerConstants.ALL_USER_CREATED_ISSUES_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_USER_CREATED_ISSUES_OPERATION_NOTE,
            response= Iterable.class)
    @GetMapping(value = "/created",  produces = "application/json")
    public Iterable<Issue> getCreatedByIssuesForUser(HttpServletRequest httpServletRequest) {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        return issueService.getCreatedByIssuesForUser(jwtToken);
    }

    @ApiOperation(value = ApiSwaggerConstants.ALL_USER_REVIEWED_ISSUES_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_USER_REVIEWED_ISSUES_OPERATION_NOTE,
            response= Iterable.class)
    @GetMapping(value = "/reviewed", produces = "application/json")
    public Iterable<Issue> getReviewedByIssuesForUser(HttpServletRequest httpServletRequest) {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        return issueService.getReviewedByIssuesForUser(jwtToken);
    }

    @ApiOperation(value = ApiSwaggerConstants.ALL_USER_ASSIGNED_ISSUES_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_USER_ASSIGNED_ISSUES_OPERATION_NOTE,
            response= Iterable.class)
    @GetMapping(value = "/assigned",  produces = "application/json")
    public Iterable<Issue> getAssignedToIssuesForUser(HttpServletRequest httpServletRequest) {
        String jwtToken = httpServletRequest.getHeader("Authorization");
        jwtToken = jwtToken.substring(7);
        return issueService.getAssignedToIssuesForUser(jwtToken);
    }
}
