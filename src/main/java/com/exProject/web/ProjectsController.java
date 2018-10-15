package com.exProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exProject.domain.Project;
import com.exProject.domain.ProjectAssignment;
import com.exProject.domain.ProjectAssignmentRepository;
import com.exProject.domain.ProjectRepository;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectAssignmentRepository projectAssignmentRepository;
	
	@RequestMapping(value="")
	public Iterable<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	@RequestMapping(value="/findByUserId/{userId}", method=RequestMethod.GET)
	public List<Project> getProjects(@PathVariable("userId") Long userId) {
		return projectRepository.findByUserId(userId);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public Project createProject(@RequestBody Project project, @PathVariable Long userId) {
		Project retVal = projectRepository.save(project);
		// Create an object of ProjectAssignment with the given projectId.
		ProjectAssignment projectAssignment = new ProjectAssignment(retVal.getProjectId(), userId);
		projectAssignmentRepository.save(projectAssignment);
		// Return the Project instance. 
		return retVal;
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.DELETE)
	public void deleteProject(@PathVariable("projecdtId") Long projectId) {
		projectRepository.deleteById(projectId);
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.PATCH)
	public void updateProject(@RequestBody Project project, @PathVariable("projectId") Long projectId) {
		project.setProjectId(projectId);
		projectRepository.save(project);
	}

}
