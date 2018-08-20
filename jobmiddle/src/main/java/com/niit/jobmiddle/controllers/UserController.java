package com.niit.jobmiddle.controllers;

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

import com.niit.jobzzz.dao.UserDao;
import com.niit.jobzzz.model.User;

@RestController
@RequestMapping(value="register")
public class UserController {

	@Autowired
	UserDao userDAO;
	
	@GetMapping
	public ResponseEntity<List<User>> getAllusers()
	{
	List<User> users = userDAO.showAllCustomer();
	if(users.isEmpty())
	{
		return new ResponseEntity<List<User>>(users, HttpStatus.NO_CONTENT);
	}
	else
	{
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<User> getOneuser(@PathVariable("email") String email)
	{
	User user = userDAO.showCustomer(email);
	if(user != null)
	{
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
	}
	}
	
	@PostMapping
	public ResponseEntity<Void> insertOrUpdateuser(@RequestBody User user)
	{
	if(userDAO.addCustomer(user)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Void> deleteuser(@PathVariable("email") String email)
	{
	if(userDAO.delCustomer(email)) {
		return new ResponseEntity<Void>(HttpStatus.OK);
	}else {
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	}

}
