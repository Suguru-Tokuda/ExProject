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
	@Column(name="previlegeName", columnDefinition="VARCHAR(30)")
	private String previlegeName;
	
	public Previlege() {
	}
	
	public Previlege(Long previlegeId, String previlegeName, Long userTypeOptionId) {
		this.previlegeId = previlegeId;
		this.previlegeName = previlegeName;
	}
	
	public Previlege(String previlegeName, Long userTypeOptionId) {
		this.previlegeName = previlegeName;
	}
	
	public Long getPrevilegeId() {
		return previlegeId;
	}
	
	public void setPrevilegeId(Long previlegeId) {
		this.previlegeId = previlegeId;
	}
	
	public String getprevilegeName() {
		return previlegeName;
	}
	
	public void setPrevilegeName(String previlegeName) {
		this.previlegeName = previlegeName;
	}

}
