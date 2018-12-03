package com.executor.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.User;
import com.executor.domain.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value="", method=RequestMethod.GET, produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Iterable<User> getUsers(@RequestParam(value="email", required=false) String email, @RequestParam(value="firstName", required=false) String firstName, @RequestParam(value="lastName", required=false) String lastName) {	
		List<User> userList = new ArrayList<>();
		if (email == null && firstName == null && lastName == null) {
			return userRepository.findAll();	
		} else {
			List<User> tempList = null;
			Iterator<User> iterator = null;
			if (email != null) {
				User user = userRepository.findByEmail(email);
				if (user != null)
					userList.add(user);
			}
			if (firstName != null) {
				tempList = userRepository.findByFirstName(firstName);
				iterator = tempList.iterator(); 
				while (iterator.hasNext()) {
					User user = iterator.next();
					if (!userList.contains(user)) {
						userList.add(user);
					}
				}
			}
			if (lastName != null) {
				tempList = userRepository.findByLastName(lastName);
				iterator = tempList.iterator(); 
				while (iterator.hasNext()) {
					User user = iterator.next();
					if (!userList.contains(user)) {
						userList.add(user);
					}
				}
			}
		}
		return userList;
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public Optional<User> getUser(@PathVariable Long userId) {
		return userRepository.findById(userId);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") Long userId) {
		userRepository.deleteById(userId);
	}
	
	@RequestMapping(value="/availability")
	public boolean getAvailability(@RequestParam(value="email", required=false) String email) {
		return userRepository.findByEmail(email) == null;
	}
	
	@RequestMapping(value="/updateEmail", method=RequestMethod.PUT)
	public void updateEmail(@RequestBody String oldEmail, @RequestBody String newEmail) {
		// Check if the old email exists.
		if (userRepository.findByEmail(oldEmail) != null)
			userRepository.updateEmail(newEmail, oldEmail);
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public void confirmUser(@RequestBody Long userId) {
		// If there is a record for the email, it confirms for the email
		if (userRepository.findById(userId) != null)
			userRepository.confirm(userId);
	}
	
	@RequestMapping(value="/archive", method=RequestMethod.POST)
	public void archiveUser(@RequestBody Long userId, @RequestBody String email) {
		// If there is a record for the email, it archives for the email
		if (userRepository.findByEmail(email) != null)
			userRepository.archive(userId);
	}
	
}
