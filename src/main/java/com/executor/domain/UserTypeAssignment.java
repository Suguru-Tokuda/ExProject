package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="UserTypeAssignments")
@XmlRootElement
public class UserTypeAssignment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userTypeAssignmentId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long userTypeAssignmentId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	@Column(name="userTypeId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userTypeId;
	
	public UserTypeAssignment() {
	}
	
	public UserTypeAssignment(Long userId, Long userTypeId) {
		this.userId = userId;
		this.userTypeId = userTypeId;
	}	
	
	public UserTypeAssignment(Long userTypeAssignmentId, Long userId, Long userTypeId) {
		this.userTypeAssignmentId = userTypeId;
		this.userId = userId;
		this.userTypeId = userTypeId;
	}

	public Long getuserTypeAssignmentId() {
		return userTypeAssignmentId;
	}
	public void setuserTypeAssignmentId(Long userTypeId) {
		this.userTypeAssignmentId = userTypeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

}