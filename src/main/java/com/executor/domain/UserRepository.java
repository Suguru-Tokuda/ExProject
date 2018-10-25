package com.executor.domain;

import java.sql.Date;
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
	
	@Query("UPDATE User u SET u.lastLoginDateTime = ?1, u.token = ?2 WHERE u.userId = ?3")
	void setLoginInfo(Date loginDateTime, String token, Long userId);
	
	@Query("SELECT u FROM User u WHERE u.userId = ?1 AND u.password = ?2 AND u.token = ?3")
	List<User> findByLoginInfo(String password, Long userId, String token);
	
	@Query("UPDATE User u SET u.token = NULL, u.lastLoginDateTime = NULL WHERE u.userId = ?1")
	void logout(Long userId);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2 AND u.token = ?3")
	List<User> findToAuthenticate(String email, String encodedPassword, String token);
	
}
