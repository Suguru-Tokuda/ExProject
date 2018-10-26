package com.executor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Previlege;
import com.executor.domain.PrevilegeRepository;

@RestController
@RequestMapping("/previleges")
public class PrevilegeController {
	
	@Autowired
	PrevilegeRepository previlegeRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Previlege getPrevilege(@RequestParam(value="userTypeOptionId", required=true) Long userTypeOptionId) {
		return previlegeRepository.findByUserTypeOptionId(userTypeOptionId).get(0);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public Previlege createPrevilege(@RequestBody Previlege previlege) {
		return previlegeRepository.save(previlege);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public Previlege updatePrevilege(@RequestBody Previlege previlege) {
		return previlegeRepository.save(previlege);
	}
	
	@RequestMapping(value="/{previlegeId}", method=RequestMethod.DELETE)
	public void deletePrevilege(@PathVariable("previlegeId") Long previlegeId) {
		previlegeRepository.deleteById(previlegeId);
	}
	

}
