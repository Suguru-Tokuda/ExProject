package com.executor.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Users")
@XmlRootElement(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userId", columnDefinition="BIGINT")
	private Long userId;
	@Column(name="username", columnDefinition="VARCHAR(30) NOT NULL UNIQUE")
	private String username;
	@Column(name="firstName", columnDefinition="VARCHAR(30) NOT NULL")
	private String firstName;
	@Column(name="lastName", columnDefinition="VARCHAR(30) NOT NULL")
	private String lastName;
	@Column(name="email", columnDefinition="VARCHAR(50) NOT NULL UNIQUE")
	private String email;
	@Column(name="password", columnDefinition="VARCHAR(255) NOT NULL")
	private String password;
	@Column(name="skills", nullable=true, columnDefinition="VARCHAR(2000)")
	private String skills;
	@Column(name="picture", nullable=true, columnDefinition="BLOB")
	private String picture;
	@Column(name="confirmed", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")
	private boolean confirmed;
	@Column(name="archived", columnDefinition="TINYINT(1) NOT NULL DEFAULT 0")
	private boolean archived;
	@Column(name="role", nullable=false, columnDefinition="VARCHAR(10) DEFAULT 'User'")
	private String role;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="UserProjectAssignments", joinColumns = {
	@JoinColumn(name="userId", nullable=false, updatable=false)}, inverseJoinColumns = { @JoinColumn(name="projectId", nullable=false, updatable=false)})
	private List<Project> projects;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<Task> tasks;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="UserAuthorityAssignments", joinColumns = {
	@JoinColumn(name="userId", nullable=false, updatable=false)}, inverseJoinColumns = { @JoinColumn(name="authorityId", nullable=false, updatable=false)})
	private List<Authority> authorities;
	
	public User() {}

    public User(Long userId) {
        this.userId = userId;
    }
    
    public User(Long userId, String username, String firstName, String lastName, String email, String password, String skills, String picture, boolean confirmed, boolean archived, String role) {
    	this.userId = userId;
    	this.username = username;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.password = password;
    	this.skills = skills;
    	this.picture = picture;
    	this.confirmed = confirmed;
    	this.archived = archived;
    	this.role = role;
    }
    
    public User(String username, String firstName, String lastName, String email, String skills, String password, String role) {
    	this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skills = skills;
        this.password = password;
        this.role = role;
        this.confirmed = false;
        this.archived = false;
    }
    
    public User(String username, String firstName, String lastName, String email, String password, String role) {
    	this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.confirmed = false;
        this.archived = false;
    }
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
        
    public User(String email, String password, boolean confirmed) {
        this.email = email;
        this.password = password;
        this.confirmed = confirmed;
    }
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getuserName() {
		return username;
	}
	
	public void setUserName(String userName) {
		this.username = userName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSkills() {
		return skills;
	}
	
	public void setSkills(String skills) {
		this.skills = skills;
	}
	
	public String getPicture() {
		return picture;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}
	
	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	
	public boolean isArchived() {
		return archived;
	}
	
	public void setArchived(boolean archived) {
		this.archived = archived;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Authority> getUserAuthorities() {
		return authorities;
	}

	public void setUserAuthorities(List<Authority> userAuthorities) {
		this.authorities = userAuthorities;
	}

}
