package com.executor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="Previleges")
@XmlRootElement
public class Previlege {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="previlegeId", columnDefinition="MEDIUMINT AUTO_INCREMENT")
	private Long previlegeId;
	@Column(name="previlegeStr", columnDefinition="VARCHAR(30)")
	private String previlegeStr; // This string is delimited by ;
	@Column(name="userTypeOptionId", columnDefinition="MEDIUMINT NOT NULL")
	private Long userTypeOptionId;
	
	public Previlege() {
	}
	
	public Previlege(Long previlegeId, String previlegeStr, Long userTypeOptionId) {
		this.previlegeId = previlegeId;
		this.previlegeStr = previlegeStr;
		this.userTypeOptionId = userTypeOptionId;
	}
	
	public Previlege(String previlegeStr, Long userTypeOptionId) {
		this.previlegeStr = previlegeStr;
		this.userTypeOptionId = userTypeOptionId;
	}
	
	public Long getPrevilegeId() {
		return previlegeId;
	}
	public void setPrevilegeId(Long previlegeId) {
		this.previlegeId = previlegeId;
	}
	public String getprevilegeStr() {
		return previlegeStr;
	}
	public void setPrevilege(String previlegeStr) {
		this.previlegeStr = previlegeStr;
	}
	public Long getUserTypeOptionId() {
		return userTypeOptionId;
	}
	public void setUserTypeOptionId(Long userTypeOptionId) {
		this.userTypeOptionId = userTypeOptionId;
	}	

}
