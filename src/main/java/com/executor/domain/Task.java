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
@Table(name="Tasks")
@XmlRootElement(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="taskId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long taskId;
	@Column(name="taskName", columnDefinition="VARCHAR(30) NOT NULL")
	private String taskName;
	@Column(name="startDate", nullable=true, columnDefinition="DATE")
	private Date startDate;
	@Column(name="endDate", nullable=true, columnDefinition="DATE")
	private Date endDate;
	@Column(name="completed", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")
	private boolean completed;
	@Column(name="approved", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")
	private boolean approved;
	
	public Task() {
	}
	
	public Task(Long taskId, String taskName, Date startDate, Date endDate, boolean completed, boolean approved) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completed = completed;
		this.approved = approved;
	}
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}
