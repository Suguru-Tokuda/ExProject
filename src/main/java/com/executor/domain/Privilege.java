package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Privileges")
@XmlRootElement
/* Holds static string values */
public class Privilege {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="privilegeId", columnDefinition="BIGINT")
	private Long privilegeId;
	@Column(name="privilegeName", columnDefinition="VARCHAR(30)")
	private String privilegeName;
	
	public Privilege() {}
	
	public Privilege(Long privilegeId, String privilegeName, Long userTypeOptionId) {
		this.privilegeId = privilegeId;
		this.privilegeName = privilegeName;
	}
	
	public Privilege(String privilegeName, Long userTypeOptionId) {
		this.privilegeName = privilegeName;
	}
	
	public Long getPrivilegeId() {
		return privilegeId;
	}
	
	public void setPrivilegeId(Long privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	public String getPrivilegeName() {
		return privilegeName;
	}
	
	public void setPrivilegeName(String privilegeName) {
		this.privilegeName = privilegeName;
	}

}
