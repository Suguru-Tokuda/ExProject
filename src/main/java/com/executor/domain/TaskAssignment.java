package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TaskAssignments")
@XmlRootElement(name="projectTaskAssignment")
public class TaskAssignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="taskAssignmentId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long taskAssignmentId;
	@Column(name="taskId", columnDefinition="MEDIUMINT NOT NULL")
	private Long taskId;
	@Column(name="projectId", columnDefinition="MEDIUMINT NOT NULL")
	private Long projectId;
	@Column(name="userId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userId;
	
	public TaskAssignment() {		
	}	
	
	public TaskAssignment(Long taskAssignmentId, Long taskId, Long projectId, Long userId) {
		this.taskAssignmentId = taskAssignmentId;
		this.taskId = taskId;
		this.projectId = projectId;
		this.userId = userId;
	}
	
	public TaskAssignment(Long taskId, Long projectId, Long userId) {
		this.taskId = taskId;
		this.projectId = projectId;
		this.userId = userId;
	}

	public Long getTaskAssignmentId() {
		return taskAssignmentId;
	}
	public void setTaskAssignmentId(Long taskAssignmentId) {
		this.taskAssignmentId = taskAssignmentId;
	}
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}