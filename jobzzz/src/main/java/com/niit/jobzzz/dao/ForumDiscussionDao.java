package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.ForumDiscussion;

public interface ForumDiscussionDao 
{
  boolean createAndUpdateFDiscussion(ForumDiscussion forumDiscussion);
  boolean deleteForumDiscussion(int id);
  List<ForumDiscussion> selectForumDiscussion(int foid);
  ForumDiscussion selectOneForumDiscussion(int id);
}
