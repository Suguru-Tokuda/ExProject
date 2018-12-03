package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Authority;
import com.executor.domain.PrivilegeRepository;
import com.executor.domain.Project;
import com.executor.domain.AuthorityRepository;
import com.executor.domain.ProjectRepository;

@RestController
@RequestMapping("/authorities")
public class AuthorityController {
	
	@Autowired
	AuthorityRepository userTypeOptionRepository;
	@Autowired
	PrivilegeRepository previlegeRepository;
	@Autowired
	ProjectRepository projectRepository;
	
	@RequestMapping(value="/{projectId}", method=RequestMethod.POST)
	public Authority createAuthority(@RequestBody Authority authority, @PathVariable("projectId") Long projectId) {
		Project project = projectRepository.findById(projectId).orElse(null);
		if (project != null) {
			// Add authority
			project.getAuthorities().add(authority);
			// Save the transaction
			projectRepository.save(project);
			return project.getAuthorities().get(project.getAuthorities().size() - 1);
		}
		return null;
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public Authority updateUserTypeOption(@RequestBody Authority userTypeOption) {
		return userTypeOptionRepository.save(userTypeOption);
	}
	
	@RequestMapping(value="/{authoritynId}", method=RequestMethod.DELETE)
	public void deleteUserTypeOption(@PathVariable("authorityId") Long authorityId) {
		userTypeOptionRepository.deleteById(authorityId);
	}

}
