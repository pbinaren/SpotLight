package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.BlogComment;

public interface BlogCommentDAo 
{
  boolean createAndUpdateBlog(BlogComment blogcomment);
  boolean deleteBlogComment(int id);
  List<BlogComment> selectmyBogComment(int blogid);
  BlogComment selectOneBlogComment(int id);
}
