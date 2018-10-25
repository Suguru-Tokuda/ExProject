package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.UserTypeAssignmentRepository;

@RestController
@RequestMapping("/userTypeAssignments")
public class UserTypeAssignmentController {

	@Autowired
	UserTypeAssignmentRepository userTypeAssignmentRepository;
	
//	@RequestMapping(value="", method=RequestMethod.GET)
//	public Iterable<UserTypeAssignments> getUserTypeAssignments
}
