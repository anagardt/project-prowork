package com.draganatasevska.finki.prowork.web.backend.repository;

import com.draganatasevska.finki.prowork.web.backend.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Dao used for project data.
 */
@Repository
public interface ProjectDao extends CrudRepository<Project, Long> {

}