package com.executor.web;

import java.util.Iterator;
import java.util.List;
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
import com.executor.domain.ProjectAssignment;
import com.executor.domain.ProjectAssignmentRepository;
import com.executor.domain.ProjectRepository;
import com.executor.domain.TaskRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectAssignmentRepository projectAssignmentRepository;
	@Autowired
	TaskRepository taskRepository;
	
	@RequestMapping(value="")
	public Iterable<Project> getProjects(@RequestParam(value="userId", required=false) Long userId) {
		List<Project> retVal = null;
		if (userId == null) 
			retVal = StreamSupport.stream(projectRepository.findAll().spliterator(), false).collect(Collectors.toList());
		else {
			retVal = projectRepository.findByUserId(userId);
		}
		/* Iterate projects and set tasks */
		for (int i = 0; i < retVal.size(); i++) {
			Project tempProject = retVal.get(i);
			tempProject.setTasks(taskRepository.findByProjectId(tempProject.getProjectId()));;
			retVal.set(i, tempProject);
		}
		return retVal;
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.GET)
	public Optional<Project> getProject(@PathVariable("projectId") Long projectId) {
		Optional<Project> tempVal = projectRepository.findById(projectId);
		Project project = tempVal.orElse(null);
		if (project != null)
			project.setTasks(taskRepository.findByProjectId(projectId));
		return Optional.of(project);
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
