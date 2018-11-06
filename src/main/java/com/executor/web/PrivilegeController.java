package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Privilege;
import com.executor.domain.PrivilegeRepository;

@RestController
@RequestMapping("/previleges")
public class PrivilegeController {
	
	@Autowired
	PrivilegeRepository previlegeRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Privilege> getPrivileges(@RequestParam(value="userTypeOptionId", required=true) Long userTypeOptionId) {
		return previlegeRepository.findAll();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Privilege createPrivilege(@RequestBody Privilege previlege) {
		return previlegeRepository.save(previlege);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public Privilege updatePrivilege(@RequestBody Privilege previlege) {
		return previlegeRepository.save(previlege);
	}
	
	@RequestMapping(value="/{previlegeId}", method=RequestMethod.DELETE)
	public void deletePrivilege(@PathVariable("previlegeId") Long previlegeId) {
		previlegeRepository.deleteById(previlegeId);
	}
	

}
