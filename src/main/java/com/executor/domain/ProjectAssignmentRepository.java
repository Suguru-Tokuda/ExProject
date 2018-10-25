package com.executor.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectAssignmentRepository extends CrudRepository <ProjectAssignment, Long> {
	
	List<ProjectAssignment> findByProjectId(Long projectId);
	List<ProjectAssignment> findByUserId(Long userId);

}
