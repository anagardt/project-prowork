package com.draganatasevska.finki.prowork.web.backend.service.implementation;

import com.draganatasevska.finki.prowork.web.backend.model.Project;
import com.draganatasevska.finki.prowork.web.backend.repository.ProjectDao;
import com.draganatasevska.finki.prowork.web.backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * The implementation of @{@link ProjectService}
 */
@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;

    @Override
    public Project createProject(Project project) {
        return projectDao.save(project);
    }

    @Override
    public Iterable<Project> getAllProjects() {
        return projectDao.findAll();
    }
}
