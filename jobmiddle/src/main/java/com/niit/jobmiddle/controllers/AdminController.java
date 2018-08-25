package com.niit.jobmiddle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.jobzzz.dao.BlogDao;
import com.niit.jobzzz.dao.JobDao;
import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.Job;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	BlogDao blogDAO;
	
	@Autowired
	JobDao jobDAO;
	
	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs()
	{
	List<Blog> blogs = blogDAO.selectUnapprovedBlog();
			if(blogs.isEmpty())
	{
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
	}
	}
	
	@DeleteMapping("blog/{id}")
	public ResponseEntity<Void> deleteBlog(@PathVariable("id") int id)
	{
	if(blogDAO.deleteBlog(id)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@PutMapping("blogapprove/{id}")
	public ResponseEntity<Void> updateBlog(@PathVariable("id") int id)
	{
		Blog blog =blogDAO.selectOneBlog(id);
		blog.setStatus(true);
		
	if(blogDAO.createAndUpdateBlog(blog)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getAlljobs()
	{
	List<Job> jobs = jobDAO.selectUnapprovedJob();
			if(jobs.isEmpty())
	{
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
	}
	
	@DeleteMapping("job/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable("id") int id)
	{
	if(jobDAO.deleteJob(id)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@PutMapping("jobapprove/{id}")
	public ResponseEntity<Void> updateJob(@PathVariable("id") int id)
	{
		Job job = jobDAO.selectOneJob(id);
		job.setStatus(true);
		
	if(jobDAO.createAndUpdateJob(job)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}

}
