package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.User;

@Repository("userDAO")
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCustomer(User user) {
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean delCustomer(String email) {
		try {
			sessionFactory.getCurrentSession().delete(showCustomer(email));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public User showCustomer(String email) {
		try {
			User user= (User) sessionFactory.getCurrentSession().createQuery("from User where email ='"+email+"'").uniqueResult();
			
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public List<User> showAllCustomer() {
		try {
			List<User> user = (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
