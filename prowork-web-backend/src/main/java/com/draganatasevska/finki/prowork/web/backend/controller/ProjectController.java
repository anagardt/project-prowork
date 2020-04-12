package com.draganatasevska.finki.prowork.web.backend.controller;

import com.draganatasevska.finki.prowork.web.backend.constants.ApiSwaggerConstants;
import com.draganatasevska.finki.prowork.web.backend.model.Project;
import com.draganatasevska.finki.prowork.web.backend.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(value = ApiSwaggerConstants.PROJECT_API_VALUE)
@RestController
@RequestMapping(value = "/api/project", produces = MediaType.ALL_VALUE)
@CrossOrigin
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @ApiOperation(value = ApiSwaggerConstants.CREATE_PROJECT_OPERATION_VALUE,
            notes= ApiSwaggerConstants.CREATE_PROJECT_OPERATION_NOTE,
            response= Project.class)
    @PostMapping(value = "/new", produces = "application/json")
    public Project createProject(@RequestBody Project newProject){
        return this.projectService.createProject(newProject);
    }

    @ApiOperation(value = ApiSwaggerConstants.ALL_PROJECTS_OPERATION_VALUE,
            notes= ApiSwaggerConstants.ALL_PROJECTS_OPERATION_NOTE,
            response= Iterable.class)
    @GetMapping(value = "/getAll", produces = "application/json")
    public Iterable<Project> getAllProjects() {
        return projectService.getAllProjects();
    }
}
