package com.niit.jobzzz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String blogTitle;
	
	@Column(columnDefinition="text")
	private String blogDescription;
	
	private String blogAuthor;
	
	private boolean status;
	
	private String createdOn;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	public String getBlogAuthor() {
		return blogAuthor;
	}
	public void setBlogAuthor(String blogAuthor) {
		this.blogAuthor = blogAuthor;
	}public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
