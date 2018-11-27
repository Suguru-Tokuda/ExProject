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
	@Column(name="taskAssignmentId", columnDefinition="BIGINT AUTO_INCREMENT")
	private Long taskAssignmentId;
	@Column(name="taskId", columnDefinition="BIGINT NOT NULL")
	private Long taskId;
	@Column(name="userId", columnDefinition="BIGINT NOT NULL")
	private Long userId;
	
	public TaskAssignment() {		
	}	
	
	public TaskAssignment(Long taskAssignmentId, Long taskId, Long userId) {
		this.taskAssignmentId = taskAssignmentId;
		this.taskId = taskId;
		this.userId = userId;
	}
	
	public TaskAssignment(Long taskId, Long userId) {
		this.taskId = taskId;
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
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

}