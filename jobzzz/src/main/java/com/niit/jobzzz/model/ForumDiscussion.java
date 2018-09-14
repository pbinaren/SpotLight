package com.niit.jobzzz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ForumDiscussion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fdid;

	private int foid;

	@Column(columnDefinition = "text")
	private String fdiscussion;
	
	private String postedby;
	
	private String createdOn;
	
	public int getFdid() {
		return fdid;
	}
	public void setFdid(int fdid) {
		this.fdid = fdid;
	}
	public int getFoid() {
		return foid;
	}
	public void setFoid(int foid) {
		this.foid = foid;
	}
	public String getFdiscussion() {
		return fdiscussion;
	}
	public void setFdiscussion(String fdiscussion) {
		this.fdiscussion = fdiscussion;
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
