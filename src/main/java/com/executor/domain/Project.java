package com.executor.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Projects")
@XmlRootElement(name="proejct")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="projectId",columnDefinition="BIGINT")
	private Long projectId;
	@Column(name="projectName", columnDefinition="VARCHAR(30) NOT NULL")
	private String projectName;
	@Column(name="startDate", nullable=true, columnDefinition="DATE")
	private Date startDate;
	@Column(name="endDate", nullable=true, columnDefinition="DATE")
	private Date endDate;
	@Column(name="completed", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")
	private boolean completed;
	@Column(name="picture", nullable=true, columnDefinition="BLOB")
	private String picture;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project")
	private List<Task> tasks;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="project")
	private List<UserTypeOption> userTypeOptions;
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="projects")
	private List<User> users;
	
	public Project() {
	}
	
	public Project(Long projectId, String projectName, Date startDate, Date endDate, boolean completed,
			String picture) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completed = completed;
		this.picture = picture;
	}

	public Project(Long projectId, String projectName, Date startDate, Date endDate, boolean completed) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completed = completed;
	}
	
	public Project(String projectName, Date startDate, Date endDate) {
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public Long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<UserTypeOption> getUserTypeOptions() {
		return userTypeOptions;
	}

	public void setUserTypeOptions(List<UserTypeOption> userTypeOptions) {
		this.userTypeOptions = userTypeOptions;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
