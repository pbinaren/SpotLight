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

import com.niit.jobzzz.dao.ForumDiscussionDao;
import com.niit.jobzzz.model.BlogComment;
import com.niit.jobzzz.model.ForumDiscussion;

@RestController
@RequestMapping(value="forumdiscussion")
public class ForumDiscussionController 
{

	@Autowired
	ForumDiscussionDao forumDiscussionDAO;
	
	@GetMapping("/{foid}")
	public ResponseEntity<List<ForumDiscussion>> getAllForumDiscussions(@PathVariable("foid") int foid)
	{
	List<ForumDiscussion> discussion = forumDiscussionDAO.selectForumDiscussion(foid);
	if(discussion.isEmpty())
	{
		return new ResponseEntity<List<ForumDiscussion>>(discussion, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<ForumDiscussion>>(discussion, HttpStatus.OK);
	}
	}
	
	@PostMapping
	public ResponseEntity<Void> insertOrUpdateForumDiscussion(@RequestBody ForumDiscussion forumdiscussion)
	{
		forumdiscussion.setCreatedOn((new Date()).toString());
	if(forumDiscussionDAO.createAndUpdateFDiscussion(forumdiscussion)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@DeleteMapping("forumdiscussion/{id}")
	public ResponseEntity<Void> deleteFdiscussion(@PathVariable("id") int id)
	{
	if(forumDiscussionDAO.deleteForumDiscussion(id)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
}
