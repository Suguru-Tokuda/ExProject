package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeRepository extends CrudRepository <UserType, Long> {
	
	@Query(value="SELECT * FROM UserTypes ut WHERE ut.userId = ?1 AND ut.projectId = ?2", nativeQuery=true)
	List<UserType> findByParams(Long userId, Long projectId);
	
	@Query(value="DELETE FROM UserTypes ut WHERE ut.userId = ?1 AND ut.projectId = ?2", nativeQuery=true)
	void deleteByParams(Long userId, Long projectId);

}
