package com.executor.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="UserTypeOptions")
@XmlRootElement
/* This class holds which privilege users have for a particular project  */
public class UserTypeOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userTypeOptionId", columnDefinition="BIGINT")
	private Long userTypeOptionId;
	@Column(name="userType", columnDefinition="VARCHAR(30)")
	private String userType;
	@Column(name="privilegeStr", columnDefinition="VARCHAR(255)")
	private String privilegeStr;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId", nullable=false, columnDefinition="BIGINT")
	private Project project;
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="userTypeOptions")
	private List<User> users;
	
	public UserTypeOption() {	
	}
	
	public UserTypeOption(Long userTypeOptionId, String userType, String privilegeStr) {
		this.userTypeOptionId = userTypeOptionId;
		this.userType = userType;
		this.privilegeStr = privilegeStr;
	}
	
	public UserTypeOption(String userType, String privilegeStr) {
		this.userType = userType;
		this.privilegeStr = privilegeStr;
	}	
	
	public Long getUserTypeOptionId() {
		return userTypeOptionId;
	}
	
	public void setUserTypeOptionId(Long userTypeOptionId) {
		this.userTypeOptionId = userTypeOptionId;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
