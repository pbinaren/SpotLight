package com.niit.jobzzz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int notid;
	
	String blogTitle;
	
	String email;
	
	String status;
	
	boolean viewed;

	public int getNotid() {
		return notid;
	}

	public void setNotid(int notid) {
		this.notid = notid;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
