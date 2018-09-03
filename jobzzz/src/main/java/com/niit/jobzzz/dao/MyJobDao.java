package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.MyJobs;

public interface MyJobDao
{
	boolean createAndUpdateJob(MyJobs job);
	List<MyJobs> selectAllJob(String emailid);
}
