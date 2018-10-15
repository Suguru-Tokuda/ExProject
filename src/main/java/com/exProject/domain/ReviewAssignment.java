package com.exProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ReviewAssignments")
@XmlRootElement(name="reviewAssignment")
public class ReviewAssignment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reviewAssignmentId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long reviewAssignmentId;
	@Column(name="reviewId", columnDefinition="MEDIUMINT NOT NULL")
	private Long reviewId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	@Column(name="reviewerId", columnDefinition="MEDIUMINT NOT NULL")
	private Long reviewerId;
	@Column(name="projectId", columnDefinition="MEDIUMINT NOT NULL")
	private Long projectId;
	
	public ReviewAssignment() {		
	}
	
	public ReviewAssignment(Long reviewId, Long userId, Long reviewerId, Long projectId) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.reviewerId = reviewerId;
		this.projectId = projectId;
	}

	public ReviewAssignment(Long reviewAssignmentId, Long reviewId, Long userId, Long reviewerId, Long projectId) {
		super();
		this.reviewAssignmentId = reviewAssignmentId;
		this.reviewId = reviewId;
		this.userId = userId;
		this.reviewerId = reviewerId;
		this.projectId = projectId;
	}

	public Long getReviewAssignmentId() {
		return reviewAssignmentId;
	}
	public void setReviewAssignmentId(Long reviewAssignmentId) {
		this.reviewAssignmentId = reviewAssignmentId;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getReviewerId() {
		return reviewerId;
	}
	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	
	
}
