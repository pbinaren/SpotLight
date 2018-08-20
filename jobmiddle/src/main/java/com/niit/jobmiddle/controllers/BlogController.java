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

import com.niit.jobzzz.dao.BlogDao;
import com.niit.jobzzz.model.Blog;

@RestController
@RequestMapping(value="blog")
public class BlogController 
{

	@Autowired
	BlogDao blogDAO;
	
	@GetMapping
	public ResponseEntity<List<Blog>> getAllBlogs()
	{
	List<Blog> blogs = blogDAO.selectAllBog();
	if(blogs.isEmpty())
	{
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Blog> getOneBlog(@PathVariable("id") int id)
	{
	Blog blog = blogDAO.selectOneBlog(id);
	if(blog != null)
	{
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
	}
	}
	
	@PostMapping
	public ResponseEntity<Void> insertOrUpdateBlog(@RequestBody Blog blog)
	{
		blog.setCreatedOn((new Date()).toString());
	if(blogDAO.createAndUpdateBlog(blog)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	
}
