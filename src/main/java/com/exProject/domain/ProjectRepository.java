package com.exProject.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository <Project, Long> {
	// Fetch projects by projectName
	List<Project> findByProjectName(String projectName);
	@Query(value="SELECT * FROM Projects p JOIN ProjectAssignments pa WHERE pa.userId = ?1", nativeQuery=true)
	List<Project> findByUserId(Long userId);
	
}
