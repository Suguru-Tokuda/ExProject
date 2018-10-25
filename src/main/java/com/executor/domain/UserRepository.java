package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
	// Fetch users by userName
	User findByUsername(String username);
	// Fetch users by firstName
	List<User> findByFirstName(String firstName);
	// Fetch users by lastName
	List<User> findByLastName(String lastName);
	// Fetch users by email
	User findByEmail(String email);
	
	@Query("UPDATE User u SET u.email = ?1 WHERE u.email = ?2")
	void updateEmail(String newEmail, String oldEmail);
	
	@Query("UPDATE User u SET u.confirmed = 1 WHERE u.userId = ?1")
	void confirm(Long userId);
	
	@Query("UPDATE User u SET u.archived = 1 WHERE u.userId = ?1")
	void archive(Long userId);
	
}
