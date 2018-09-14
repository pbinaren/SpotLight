package com.niit.jobzzz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LikeDislike {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	
	private int blogid;
	
	private int likecount;
	
	private int dislikecount;

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	public int getDislikecount() {
		return dislikecount;
	}

	public void setDislikecount(int dislikecount) {
		this.dislikecount = dislikecount;
	}
	
	
}
