package org.irvin.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "levels")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Level implements Serializable {
	
	private static final long serialVersionUID = -7891883479476383113L;

	@Id
	private String level_id;
	
	@NotBlank
	private String level_desc;
	
		
	public String getLevel_id() {
		return level_id;
	}
	public void setLevel_id(String level_id) {
		this.level_id = level_id;
	}
	public String getLevel_desc() {
		return level_desc;
	}
	public void setLevel_desc(String level_desc) {
		this.level_desc = level_desc;
	}
	
	
}
