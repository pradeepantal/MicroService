package com.microservice.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bookmark {

	@Id
	@GeneratedValue
	private Long id;
	
	private String href;
	
	private String userId;
	
	private String description;
	
	public Bookmark(){
		
	}

	public Bookmark(String href, String userId, String description) {

		this.href = href;
		this.userId = userId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bookmark{" + "id=" + id + ", href='" + href + '\'' + ", userId='" + userId + '\'' + ", description='"
				+ description + '\'' + '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
