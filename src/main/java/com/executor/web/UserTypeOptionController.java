package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.PrevilegeRepository;
import com.executor.domain.UserTypeOption;
import com.executor.domain.UserTypeOptionRepository;

@RestController
@RequestMapping("/userTypeOptions")
public class UserTypeOptionController {
	
	@Autowired
	UserTypeOptionRepository userTypeOptionRepository;
	@Autowired
	PrevilegeRepository previlegeRepository;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public UserTypeOption createUserTypeOption(@RequestBody UserTypeOption userTypeOption) {
		return userTypeOptionRepository.save(userTypeOption);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public UserTypeOption updateUserTypeOption(@RequestBody UserTypeOption userTypeOption) {
		return userTypeOptionRepository.save(userTypeOption);
	}
	
	@RequestMapping(value="/{userTypeOptionId}", method=RequestMethod.DELETE)
	public void deleteUserTypeOption(@PathVariable("userTypeOptionId") Long userTypeOptionId) {
		userTypeOptionRepository.deleteById(userTypeOptionId);
	}

}
