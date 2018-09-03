package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.Blog;

public interface BlogDao 
{
  boolean createAndUpdateBlog(Blog blog);
  boolean deleteBlog(int blogid);
  List<Blog> selectAllBog();
  List<Blog> selectUnapprovedBlog();
  Blog selectOneBlog(int blogid);
  List<Blog> MyBlogs(String Email); 
}
