package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="UserTypeOptions")
@XmlRootElement
/* This class holds which privilege users have for a particular project  */
public class UserTypeOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userTypeOptionId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long userTypeOptionId;
	@Column(name="projectId", columnDefinition="MEDIUMINT NOT NULL")
	private Long projectId;
	@Column(name="userType", columnDefinition="VARCHAR(30)")
	private String userType;
	@Column(name="privilegeStr", columnDefinition="VARCHAR(255)")
	private String privilegeStr;
	
	public UserTypeOption() {		
	}
	
	public UserTypeOption(Long userTypeOptionId, Long projectId, String userType, String privilegeStr) {
		this.userTypeOptionId = userTypeOptionId;
		this.projectId = projectId;
		this.userType = userType;
		this.privilegeStr = privilegeStr;
	}
	
	public UserTypeOption(Long projectId, String userType, String privilegeStr) {
		this.projectId = projectId;
		this.userType = userType;
		this.privilegeStr = privilegeStr;
	}	
	
	public Long getUserTypeOptionId() {
		return userTypeOptionId;
	}
	
	public void setUserTypeOptionId(Long userTypeOptionId) {
		this.userTypeOptionId = userTypeOptionId;
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
	
	public String getPrivilegeStr() {
		return privilegeStr;
	}
	
	public void setPrivilegeStr(String privilegeStr) {
		this.privilegeStr = privilegeStr;
	}
	

}
