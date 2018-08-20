package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.User;

public interface UserDao 
{
	public boolean addCustomer(User user);
	public boolean delCustomer(String email);
	public User showCustomer(String email);
	public List<User> showAllCustomer();
}
