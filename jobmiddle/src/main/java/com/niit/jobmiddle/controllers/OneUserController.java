package com.niit.jobmiddle.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.jobzzz.dao.BlogDao;
import com.niit.jobzzz.dao.MyJobDao;
import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.MyJobs;

@RestController
@RequestMapping(value = "/mydata")
public class OneUserController {

	@Autowired
	BlogDao blogDAO;

	@Autowired
	MyJobDao jobDAO;

	@GetMapping("/blog")
	public ResponseEntity<List<Blog>> getmyBlog(@RequestParam("email") String email)
	{
		
		System.out.println("welcome"+email);

		List<Blog> b = blogDAO.MyBlogs(email);
		if (b.isEmpty()) {
			System.out.println("hi");
			return new ResponseEntity<List<Blog>>(b, HttpStatus.NO_CONTENT);

		} else {
			System.out.println("bye");

			return new ResponseEntity<List<Blog>>(b, HttpStatus.OK);
		}
	}

	@GetMapping("/jobs/{email}")
	public ResponseEntity<List<MyJobs>> getAlljobs(@PathVariable("email") String email) {
		List<MyJobs> jobs = jobDAO.selectAllJob(email);
		if (jobs.isEmpty()) {
			return new ResponseEntity<List<MyJobs>>(jobs, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<MyJobs>>(jobs, HttpStatus.OK);
		}
	}

	@PutMapping("/jobs")
	public ResponseEntity<Void> updateJob(@RequestBody MyJobs job) {
		if (jobDAO.createAndUpdateJob(job)) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("blog/{blogid}")
	public ResponseEntity<Void> deleteBlog(@PathVariable("blogid") int blogid)
	{
	if(blogDAO.deleteBlog(blogid)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
}
