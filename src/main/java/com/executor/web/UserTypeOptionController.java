package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.PrivilegeRepository;
import com.executor.domain.User;
import com.executor.domain.UserRepository;
import com.executor.domain.UserTypeOption;
import com.executor.domain.UserTypeOptionRepository;

@RestController
@RequestMapping("/userTypeOptions")
public class UserTypeOptionController {
	
	@Autowired
	UserTypeOptionRepository userTypeOptionRepository;
	@Autowired
	PrivilegeRepository previlegeRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value="/{userId}", method=RequestMethod.POST)
	public UserTypeOption createUserTypeOption(@RequestBody UserTypeOption userTypeOption, @PathVariable("userId") String userId) {
		// Get the user object
		User user = userRepository.findById(Long.parseLong(userId)).orElse(null);
		if (user != null) {
			// Add userTypeOption 
			user.getUserTypeOptions().add(userTypeOption);
			// Save the transaction
			userRepository.save(user);
			return user.getUserTypeOptions().get(user.getUserTypeOptions().size() - 1);
		}
		return null;
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
