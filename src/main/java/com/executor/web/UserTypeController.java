package com.executor.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.UserType;
import com.executor.domain.UserTypeOption;
import com.executor.domain.UserTypeOptionRepository;
import com.executor.domain.UserTypeRepository;


@RestController
@RequestMapping("/userTypes")
public class UserTypeController {
	
	@Autowired
	UserTypeRepository userTypeRepository;
	@Autowired
	UserTypeOptionRepository userTypeOptionRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public UserType getUserType(@RequestParam(value="userId", required=true) Long userId, @RequestParam(value="projectId", required=true) Long projectId){
		List<UserTypeOption> userTypeOptions = userTypeOptionRepository.findByProjectId(projectId);
		Iterator<UserType> userTypeIterator = userTypeRepository.findAll().iterator();
		Iterator<UserTypeOption> userTypeOptionIterator = null;
		
		while (userTypeIterator.hasNext()) {
			UserType tempUserType = userTypeIterator.next();
			userTypeOptionIterator = userTypeOptions.iterator();
			while (userTypeOptionIterator.hasNext()) {
				UserTypeOption userTypeOption = userTypeOptionIterator.next();
				if (tempUserType.getUserId() == userId && tempUserType.getUserTypeOptionId() == userTypeOption.getuserTypeOptionId()) {
					return tempUserType;
				}
			}
		}
		return null;
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public UserType createUserType(@RequestBody UserType userType) {
		return userTypeRepository.save(userType);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public UserType updateUserType(@RequestBody UserType userType) {
		return userTypeRepository.save(userType);
	}
	
	@RequestMapping(value="/{userTypeId}", method=RequestMethod.DELETE)
	public void deleteUserType(@PathVariable("userTypeId") Long userTypeId) {
		userTypeRepository.deleteById(userTypeId);
	}
	
	@RequestMapping(value="", method=RequestMethod.DELETE)
	public void deleteUserType(@RequestParam(value="userId", required=true) Long userId, @RequestParam(value="projectId", required=true) Long projectId) {
		userTypeRepository.deleteByParams(userId, projectId);
	}
	
	
}
