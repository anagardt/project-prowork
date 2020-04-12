package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    Project createProject(Project project);
    long deleteProject(long projectId);
    Iterable<Project> getAllProjects();

}
