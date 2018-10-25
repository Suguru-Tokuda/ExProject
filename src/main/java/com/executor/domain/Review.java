package com.executor.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Reviews")
@XmlRootElement(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reviewId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long reviewId;
	@Column(name="title", columnDefinition="VARCHAR(30) NOT NULL")
	private String title;
	@Column(name="description", columnDefinition="VARCHAR(500) NOT NULL")
	private String description;
	@Column(name="reviewDate", columnDefinition="DATE NOT NULL")
	private Date reviewDate;
	
	public Review() {
	}
	
	public Review(Long reviewId, String title, String description, Date reviewDate) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.description = description;
		this.reviewDate = reviewDate;
	}

	public Review(String title, String description, Date reviewDate) {
		super();
		this.title = title;
		this.description = description;
		this.reviewDate = reviewDate;
	}

	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	
	
	

}
