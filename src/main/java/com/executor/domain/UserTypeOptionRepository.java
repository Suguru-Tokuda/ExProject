package com.executor.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserTypeOptionRepository extends CrudRepository <UserTypeOption, Long > {
	
	List<UserTypeOption> findByProjectId(Long projectId);

}
