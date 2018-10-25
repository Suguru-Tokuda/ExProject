package com.executor.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.executor.domain.Review;
import com.executor.domain.ReviewAssignment;
import com.executor.domain.ReviewAssignmentRepository;
import com.executor.domain.ReviewRepository;

@RestController
@RequestMapping(value="/reviews")
public class ReviewController {
	
	@Autowired
	ReviewRepository reviewRepository;
	@Autowired
	ReviewAssignmentRepository reviewAssignmentRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Review> getReviews(@RequestParam(value="userId", required=false) Long userId, @RequestParam(value="projectId", required=false) Long projectId, @RequestParam(value="reviewerId", required=false) Long reviewerId) {
		List<Review> reviewList = new ArrayList<>();		
		if (userId == null && projectId == null && reviewerId == null)
			return reviewRepository.findAll();
		else {
			List<Review> tempList = null;
			Iterator<Review> iterator = null;
			if (userId != null) {
				tempList = reviewRepository.findByUserId(userId);
				iterator = tempList.iterator();
				while (iterator.hasNext()) {
					Review review = iterator.next();
					if (!reviewList.contains(review))
						reviewList.add(review);
				}
			}
			if (projectId != null) {
				tempList = reviewRepository.findByProjectId(projectId);
				iterator = tempList.iterator();
				while (iterator.hasNext()) {
					Review review = iterator.next();
					if (!reviewList.contains(review))
						reviewList.add(review);
				}
			}
			if (reviewerId != null) {
				tempList = reviewRepository.findByReviewerId(reviewerId);
				iterator = tempList.iterator();
				while (iterator.hasNext()) {
					Review review = iterator.next();
					if (!reviewList.contains(review))
						reviewList.add(review);
				}
			}
		}
		return reviewList;		
	}
	
	@RequestMapping(value="/{reviewId}", method=RequestMethod.GET)
	public Optional<Review> getReview(@PathVariable Long reviewId) {
		return reviewRepository.findById(reviewId);
	}
	
	
	@RequestMapping(value="/{userId}/{reviewerId}/{projectId}", method=RequestMethod.POST)
	public Review createReview(@RequestBody Review review, @PathVariable("userId") Long userId, @PathVariable("reviewerId") Long reviewerId, @PathVariable("projectId") Long projectId) {
		Review retVal = reviewRepository.save(review);
		reviewAssignmentRepository.save(new ReviewAssignment(retVal.getReviewId(), userId, reviewerId, projectId));
		return retVal;
	}
	
	@RequestMapping(value="", method=RequestMethod.PATCH)
	public Review updateReview(@RequestBody Review review) {
		return reviewRepository.save(review);
	}
	
	@RequestMapping(value="/{reviewId}", method=RequestMethod.DELETE)
	public void deleteReview(@PathVariable("reviewId") Long reviewId) {
		reviewRepository.deleteById(reviewId);
		reviewAssignmentRepository.deleteForReviewId(reviewId);
	}

}
