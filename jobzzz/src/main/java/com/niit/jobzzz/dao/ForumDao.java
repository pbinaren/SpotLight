package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.Forum;

public interface ForumDao 
{
	 boolean createAndUpdateForum(Forum forum);
	  boolean deleteForum(int id);
	  List<Forum> selectAllForum();
	  Forum selectOneForum(int id);
}
