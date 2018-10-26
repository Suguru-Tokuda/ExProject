package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository <UserType, Long> {
	
	@Query(value="SELECT * FROM UserType ut WHERE ut.userId = ?1 AND ut.userTypeOptionId = ?2", nativeQuery=true)
	List<UserType> findByParams(Long userId, Long userTypeOptionId);
	
	@Query(value="DELETE FROM UserType ut WHERE ut.userId = ?1 and ut.userTypeOptionId = ?2", nativeQuery=true)
	void deleteByParams(Long userId, Long userTypeOptionId);
}
