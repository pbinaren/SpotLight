package com.niit.jobzzz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appliedid;
	private int jobid;
	private String email;

	public int getAppliedid() {
		return appliedid;
	}

	public void setAppliedid(int appliedid) {
		this.appliedid = appliedid;
	}

	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
