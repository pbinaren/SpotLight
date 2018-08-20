package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.Blog;

public interface BlogDao 
{
  boolean createAndUpdateBlog(Blog blog);
  boolean deleteBlog(int id);
  List<Blog> selectAllBog();
  List<Blog> selectUnapprovedBlog();
  Blog selectOneBlog(int id);
}
