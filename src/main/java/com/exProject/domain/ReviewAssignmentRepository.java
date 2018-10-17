package com.exProject.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewAssignmentRepository extends CrudRepository<ReviewAssignment, Long> {
	
	@Query(value="DELETE FROM ReviewAssignments WHERE reviewId = ?1", nativeQuery=true)
	void deleteForReviewId(Long reviewId);
}
