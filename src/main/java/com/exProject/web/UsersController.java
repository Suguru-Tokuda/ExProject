package com.exProject.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exProject.domain.User;
import com.exProject.domain.UserRepository;
import com.exProject.utilities.PasswordUtility;
import com.exProject.utilities.TokenGenerator;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping(value="", method=RequestMethod.GET, produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") Long userId) {
		userRepository.deleteById(userId);
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.PATCH)
	public void updateUser(@PathVariable("userId") Long userId, @RequestBody User user) {
		user.setUserId(userId);
		userRepository.save(user);
	}
	
	@RequestMapping(value="/checkAvailability/{email}")
	public boolean findAvailability(@PathVariable("email") String email) {
		return userRepository.findByEmail(email).size() == 1;
	}
	
	@RequestMapping(value="/findByEmail/{email:.+}", method=RequestMethod.GET, produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<User> findByEmail(@PathVariable("email") String email) {
		return userRepository.findByEmail(email);
	}
	
	@RequestMapping(value="/findByFirstName/{firstName}", method=RequestMethod.GET, produces={ MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<User> findByFirstName(@PathVariable("firstName") String firstName) {
		return userRepository.findByFirstName(firstName);
	}
	
	@RequestMapping(value="/updateEmail/{oldEmail:.+}", method=RequestMethod.PUT)
	public void updateEmail(@PathVariable("oldEmail") String oldEmail, @RequestBody User user) {
		if (user.getEmail() == null)
			return;
		// Check if the old email exists.
		if (userRepository.findByEmail(oldEmail).size() == 1) {
			userRepository.updateEmail(user.getEmail(), oldEmail);
		}
	}
	
	@RequestMapping(value="/confirm", method=RequestMethod.POST)
	public void confirmUser(@RequestBody User user) {
		if (user.getEmail() == null)
			return;
		// If there is a record for the email, it confirms for the email
		if (userRepository.findByEmail(user.getEmail()).size() == 1)
			userRepository.confirm(user.getUserId());
	}
	
	@RequestMapping(value="/archive", method=RequestMethod.POST)
	public void archiveUser(@RequestBody User user) {
		if (user.getEmail() == null)
			return;
		// If there is a record for the email, it archives for the email
		if (userRepository.findByEmail(user.getEmail()).size() == 1)
			userRepository.archive(user.getUserId());
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody User user) {
		List<User> userList = userRepository.findByEmail(user.getEmail());
		if (userList.size() > 0) {
			User userInRecord = userList.get(0);
			// Check if the provided password matches 
			if (PasswordUtility.verifyUserPassword(user.getPassword(), userInRecord.getPassword())) {
				String token = new TokenGenerator().getToken();
				java.util.Date date = new java.util.Date();
				Long userId = userList.get(0).getUserId();
				userRepository.setLoginInfo(new java.sql.Date(date.getTime()), token, userId);
				return token;				
			}
		}		
		return null;
	}
	
	@RequestMapping(value="/loout", method=RequestMethod.POST)
	public boolean logout(@RequestBody User user) {
		List<User> userList = userRepository.findByLoginInfo(PasswordUtility.generateSecurePassword(user.getPassword()), user.getUserId(), user.getToken());
		if (userList.size() > 0) {
			userRepository.logout(user.getUserId());
			return true;
		}
		return false;
	}
	
    /*
    This function takes a Users object and returns a boolean value
    if the client returns the correct token and accessed time is within 15 minutes after login
    */
	private boolean authenticate(String email, String password, String token) {
		String encodedPassword = PasswordUtility.generateSecurePassword(password);
		return userRepository.findToAuthenticate(email, encodedPassword, token).size() == 1;
	}
	
}
