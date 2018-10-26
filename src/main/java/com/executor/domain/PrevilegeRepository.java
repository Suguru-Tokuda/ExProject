package com.executor.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PrevilegeRepository extends CrudRepository<Previlege, Long> {
	
	@Query(value="SELECT * FROM Previleges p WHERE p.userTypeOptionId = ?1", nativeQuery=true)
	List<Previlege> findByUserTypeOptionId(Long userTypeOptionId);
	
	@Query(value="DELETE FROM Previleges p WHERE p.userTypeOptionId = ?1", nativeQuery=true)
	void deleteByUserTypeOptionId(Long userTypeOptionId);
}
