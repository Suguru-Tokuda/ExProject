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
	@Column(name="reviewId", columnDefinition="BIGINT")
	private Long reviewId;
	@Column(name="title", columnDefinition="VARCHAR(30) NOT NULL")
	private String title;
	@Column(name="reviewDescription", columnDefinition="VARCHAR(500) NOT NULL")
	private String reviewDescription;
	@Column(name="postDate", columnDefinition="DATE NOT NULL")
	private Date postDate;
	
	public Review() {
	}
	
	public Review(Long reviewId, String title, String reviewDescription, Date postDate) {
		super();
		this.reviewId = reviewId;
		this.title = title;
		this.reviewDescription = reviewDescription;
		this.postDate = postDate;
	}

	public Review(String title, String reviewDescription, Date postDate) {
		super();
		this.title = title;
		this.reviewDescription = reviewDescription;
		this.postDate = postDate;
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
		return reviewDescription;
	}
	
	public void setDescription(String description) {
		this.reviewDescription = description;
	}
	
	public Date getPostDate() {
		return postDate;
	}
	
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
