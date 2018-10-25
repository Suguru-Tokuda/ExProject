package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.UserType;
import com.executor.domain.UserTypeRepository;


@RestController
@RequestMapping("/userTypes")
public class UserTypeController {
	
	@Autowired
	UserTypeRepository userTypeRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<UserType> getUserType(@RequestParam(value="userId", required=true) Long userId, @RequestParam(value="projectId", required=true) Long projectId){
		return userTypeRepository.findByParams(userId, projectId);
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
