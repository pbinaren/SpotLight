package com.niit.jobmiddle.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.jobzzz.dao.BlogDao;
import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.LikeDislike;

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
	
	@GetMapping("/{blogid}")
	public ResponseEntity<Blog> getOneBlog(@PathVariable("blogid") int blogid)
	{
	Blog blog = blogDAO.selectOneBlog(blogid);
	if(blog != null)
	{
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<Blog>(blog, HttpStatus.NO_CONTENT);
	}
	}
	
	@GetMapping("ld/{id}")
	public ResponseEntity<LikeDislike> getLikeDislike(@PathVariable("id") int id)
	{
	LikeDislike ld = blogDAO.selectLikeDislike(id);
	if(ld != null)
	{
		return new ResponseEntity<LikeDislike>(ld, HttpStatus.OK);
	}
	else
	{
		LikeDislike ld1 =new LikeDislike();
		ld1.setBlogid(id);
		return new ResponseEntity<LikeDislike>(ld1, HttpStatus.FOUND);
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
	
	
	@PostMapping("/ld")
	public ResponseEntity<Void> insertOrUpdateLike(@RequestBody LikeDislike ld)
	{
		
	if(blogDAO.updatelike(ld)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
}
