package com.niit.jobmiddle.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.jobzzz.dao.BlogCommentDAo;
import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.BlogComment;

@RestController
@RequestMapping(value="blogcomment")
public class BlogCommentController 
{

	@Autowired
	BlogCommentDAo blogCommentDAO;
	
	@GetMapping
	public ResponseEntity<List<BlogComment>> getAllBlogComments(@PathVariable("blogid") int blogid)
	{
	List<BlogComment> comments = blogCommentDAO.selectmyBogComment(blogid);
	if(comments.isEmpty())
	{
		return new ResponseEntity<List<BlogComment>>(comments, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<BlogComment>>(comments, HttpStatus.OK);
	}
	}
	
	@PostMapping
	public ResponseEntity<Void> insertOrUpdateBlog(@RequestBody BlogComment blogcomment)
	{
		blogcomment.setCreatedOn((new Date()).toString());
	if(blogCommentDAO.createAndUpdateBlog(blogcomment)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@DeleteMapping("blogcomment/{id}")
	public ResponseEntity<Void> deleteBlog(@PathVariable("id") int id)
	{
	if(blogCommentDAO.deleteBlogComment(id)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
}
