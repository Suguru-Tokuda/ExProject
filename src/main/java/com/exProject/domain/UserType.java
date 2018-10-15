package com.exProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UserTypes")
@XmlRootElement
public class UserType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userTypeId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long userTypeId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	@Column(name="projectId", columnDefinition="MEDIUMINT NOT NULL")
	private Long projectId;
	@Column(name="userType", columnDefinition="VARCHAR(10) NOT NULL")
	private String userType;
	
	public UserType() {
	}
	
	public UserType(Long userId, Long projectId, String userType) {
		this.userId = userId;
		this.projectId = projectId;
		this.userType = userType;
	}	
	
	public UserType(Long userTypeId, Long userId, Long projectId, String userType) {
		this.userTypeId = userTypeId;
		this.userId = userId;
		this.projectId = projectId;
		this.userType = userType;
	}

	public Long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

}