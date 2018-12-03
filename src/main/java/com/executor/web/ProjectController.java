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

import com.executor.domain.Authority;
import com.executor.domain.AuthorityRepository;
import com.executor.domain.Project;
import com.executor.domain.ProjectRepository;
import com.executor.domain.TaskRepository;
import com.executor.domain.User;
import com.executor.domain.UserRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AuthorityRepository authorityRepository;
	
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
		User user = userRepository.findById(userId).orElse(null);
		if (user != null) {
			user.getProjects().add(project);
			userRepository.save(user);
			// Return the project that was just inserted
			return user.getProjects().get(user.getProjects().size() - 1);
		}
		// Return null if it fails. 
		return null;
	}
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.DELETE)
	public void deleteProject(@PathVariable("projecdtId") Long projectId) {
		projectRepository.deleteById(projectId);
	}
	
	@RequestMapping(method=RequestMethod.PATCH)
	public Project updateProject(@RequestBody Project project) {
		return projectRepository.save(project);
	}
	
	@RequestMapping(value="/authority", method=RequestMethod.POST)
	public Authority assignAuthority(@RequestBody Long projectId, @RequestBody Long userId) {
		Authority authority = authorityRepository.findByProjectId(projectId).orElse(null);
		if (authority != null) {
			User user = userRepository.findById(userId).orElse(null);
			if (user != null) {
				authority.getUsers().add(user);
				return authority;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/authority/{projectId}/{userId}", method=RequestMethod.DELETE)
	public boolean unassignAuthority(@RequestBody Long projectId, @RequestBody Long userId) {
		Authority authority = authorityRepository.findByProjectId(projectId).orElse(null);
		if (authority != null) {
			User user = userRepository.findById(userId).orElse(null);
			if (user != null) {
				return authority.getUsers().remove(user);
			}
		}
		return false;
	}

}
