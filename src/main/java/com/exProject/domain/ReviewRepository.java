package com.exProject.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository <Review, Long> {
	
	@Query(value="SELECT * FROM Reviews r JOIN ReviewAssignments ra ON r.reviewId = ra.reviewId WHERE ra.userId = ?1", nativeQuery=true)
	List<Review> findByUserId(Long userId);
	@Query(value="SELECT * FROM Reviews r JOIN ReviewAssignments ra ON r.reviewId = ra.reviewId WHERE ra.projectId = ?1", nativeQuery=true)
	List<Review> findByProjectId(Long projectId);
	@Query(value="SELECT * FROM Reviews r JOIN ReviewAssignments ra ON r.reviewId = ra.reviewId WHERE ra.reviewerId = ?1", nativeQuery=true)
	List<Review> findByReviewerId(Long reviewerId);
	@Query(value="SELECT * FROM Reviews r JOIN ReviewAssignments ra ON r.reviewId = ra.reviewId WHERE ra.userId = ?1 AND ra.projectId = ?2", nativeQuery=true)
	List<Review> findByUserIdProjectId(Long userId, Long projectId);
	
}
