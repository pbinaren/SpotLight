package com.niit.jobzzz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commid;

	private int blogid;

	@Column(columnDefinition = "text")
	private String blogcomment;
	private String postedby;
	private String createdOn;
	
	public int getCommid() {
		return commid;
	}
	public void setCommid(int commid) {
		this.commid = commid;
	}
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogcomment() {
		return blogcomment;
	}
	public void setBlogcomment(String blogcomment) {
		this.blogcomment = blogcomment;
	}
	public String getPostedby() {
		return postedby;
	}
	public void setPostedby(String postedby) {
		this.postedby = postedby;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
	
}
