package com.exProject.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exProject.domain.Project;
import com.exProject.domain.ProjectAssignment;
import com.exProject.domain.ProjectAssignmentRepository;
import com.exProject.domain.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectAssignmentRepository projectAssignmentRepository;
	
	@RequestMapping(value="")
	public Iterable<Project> getProjects(@RequestParam(value="userId", required=false) Long userId) {
		if (userId == null) 
			return projectRepository.findAll();
		else {
			return projectRepository.findByUserId(userId);
		}
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.GET)
	public Optional<Project> getProject(@PathVariable("projectId") Long projectId) {
		return projectRepository.findById(projectId);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public Project createProject(@RequestBody Project project, @PathVariable Long userId) {
		Project retVal = projectRepository.save(project);
		// Create an object of ProjectAssignment with the given projectId.
		projectAssignmentRepository.save(new ProjectAssignment(retVal.getProjectId(), userId));
		// Return the Project instance. 
		return retVal;
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.DELETE)
	public void deleteProject(@PathVariable("projecdtId") Long projectId) {
		projectRepository.deleteById(projectId);
	}
	
	@RequestMapping(method=RequestMethod.PATCH)
	public Project updateProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}

}
