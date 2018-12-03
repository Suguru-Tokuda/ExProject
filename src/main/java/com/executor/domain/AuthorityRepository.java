package com.executor.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository <Authority, Long > {
	
	@Query(value="SELECT * FROM a Authorities WHERE a.projectId = ?1", nativeQuery=true)
	Optional<Authority> findByProjectId(Long projectId);
	
}
