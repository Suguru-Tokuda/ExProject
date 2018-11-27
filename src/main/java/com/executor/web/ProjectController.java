package com.executor.web;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Project;
import com.executor.domain.ProjectRepository;
import com.executor.domain.TaskRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping(value="")
	public Iterable<Project> getProjects(@RequestParam(value="userId", required=false) Long userId) {
		if (userId == null) 
			return StreamSupport.stream(projectRepository.findAll().spliterator(), false).collect(Collectors.toList());
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
