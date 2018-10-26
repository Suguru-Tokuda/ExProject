package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserTypeOptionRepository extends CrudRepository <UserTypeOption, Long > {
	
	List<UserTypeOption> findByProjectId(Long projectId);
	
	@Query(value="DELETE FROM UserTypeOptions uto JOIN UserTypes ut ON uto.userTypeOptionId = ut.userTypeOptionId WHERE ut.userTypeId = ?1", nativeQuery=true)
	void deleteByUserTypeId(Long userTypeId);
}
