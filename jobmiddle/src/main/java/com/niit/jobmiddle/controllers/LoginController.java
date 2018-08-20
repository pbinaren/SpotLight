package com.niit.jobmiddle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.jobzzz.dao.UserDao;
import com.niit.jobzzz.model.User;
import com.niit.jobzzz.model.MyError;

@RestController
@RequestMapping(value="login")
public class LoginController {
	@Autowired
	UserDao userDAO;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody User user)
	{
		User existingUser = userDAO.showCustomer(user.getEmail());
		if(existingUser == null)
		{
			MyError error = new MyError();
			error.setErrorMessage("invalid email pls register");
			return new ResponseEntity<MyError>(error,HttpStatus.NOT_FOUND);
		}
		else {
			if(user.getPassword().equals(existingUser.getPassword())) {
				return new ResponseEntity<User>(existingUser,HttpStatus.OK);
			}else
			{
				MyError error = new MyError();
				error.setErrorMessage("invalid password");
				return new ResponseEntity<MyError>(error,HttpStatus.NOT_FOUND);
			}
			}
	}
}
