package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.MyJobs;
@Repository
@Transactional
public class MyJobsDaoImpl implements MyJobDao
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean createAndUpdateJob(MyJobs job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<MyJobs> selectAllJob(String emailid) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from MyJobs where email='"+emailid+"'").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	}

}
