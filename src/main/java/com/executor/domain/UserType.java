package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="UserTypes")
@XmlRootElement
public class UserType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userTypeId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long userTypeId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	@Column(name="userTypeOptionId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userTypeOptionId;
	
	public UserType() {
	}
	
	public UserType(Long userId, Long userTypeId) {
		this.userId = userId;
		this.userTypeId = userTypeId;
	}	
	
	public UserType(Long userTypeAssignmentId, Long userId, Long userTypeId) {
		this.userTypeId = userTypeId;
		this.userId = userId;
		this.userTypeId = userTypeId;
	}

	public Long getuserTypeAssignmentId() {
		return userTypeId;
	}
	public void setuserTypeAssignmentId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserTypeOptionId() {
		return userTypeOptionId;
	}
	public void setUserTypeOptionId(Long userTypeOptionId) {
		this.userTypeOptionId = userTypeOptionId;
	}

}