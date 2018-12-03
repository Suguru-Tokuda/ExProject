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
@Table(name="Authorities")
@XmlRootElement
/* This class holds which privilege users have for a particular project  */
public class Authority {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="authorityId", columnDefinition="BIGINT")
	private Long authorityId;
	@Column(name="authorityName", columnDefinition="VARCHAR(30)")
	private String authorityName;
	@Column(name="privilegeStr", columnDefinition="VARCHAR(255)")
	private String privilegeStr;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projectId", nullable=false, columnDefinition="BIGINT")
	private Project project;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<User> users;
	
	public Authority() {}
	
	public Authority(Long authorityId, String userType, String privilegeStr) {
		this.authorityId = authorityId;
		this.authorityName = userType;
		this.privilegeStr = privilegeStr;
	}
	
	public Authority(String userType, String privilegeStr) {
		this.authorityName = userType;
		this.privilegeStr = privilegeStr;
	}	
	
	public Long getAuthorityId() {
		return authorityId;
	}
	
	public void setAuthorityId(Long authorityId) {
		this.authorityId = authorityId;
	}
	
	public String getAuthorityName() {
		return authorityName;
	}
	
	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
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
