package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.Job;

public interface JobDao
{
	boolean createAndUpdateJob(Job job);
	  boolean deleteJob(int id);
	  List<Job> selectAllJob();
	  List<Job> selectUnapprovedJob();
	  Job selectOneJob(int id);
}
