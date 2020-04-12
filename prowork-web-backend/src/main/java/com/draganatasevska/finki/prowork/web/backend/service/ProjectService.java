package com.draganatasevska.finki.prowork.web.backend.service;

import com.draganatasevska.finki.prowork.web.backend.model.Project;
import org.springframework.stereotype.Service;

/**
 * Service used to provide the access functionality.
 */
@Service
public interface ProjectService {
    /**
     * Creates new project in respect to the provide Project model.
     * @param project the provided Project model.
     *
     * @return {@link Project} the newly created project.
     */
    Project createProject(Project project);

    /**
     * Returns the list of all projects.
     *
     * @return {@link Iterable<Project>} the list of projects.
     */
    Iterable<Project> getAllProjects();
}
