package com.exProject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ProjectAssignments")
@XmlRootElement(name="projectAssignment")
public class ProjectAssignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="projectAssignmentId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long projectAssignmentId;
	@Column(name="projectId", columnDefinition="MEDIUMINT NOT NULL")
	private Long projectId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	
	public ProjectAssignment(Long projectAssignmentId, Long projectId, Long userId) {
		this.projectAssignmentId = projectAssignmentId;
		this.projectId = projectId;
		this.userId = userId;
	}
	
	public ProjectAssignment(Long projectId, Long userId) {
		this.projectId = projectId;
		this.userId = userId;
	}	
	
	public Long getProjectAssignmentId() {
		return projectAssignmentId;
	}
	public void setProjectAssignmentId(Long projectAssignmentId) {
		this.projectAssignmentId = projectAssignmentId;
	}
	public Long getProjectdId() {
		return projectId;
	}
	public void setProjectdId(Long projectdId) {
		this.projectId = projectdId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
