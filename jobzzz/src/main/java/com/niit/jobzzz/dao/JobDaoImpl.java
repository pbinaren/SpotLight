package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.jobzzz.model.Job;

@Repository("jobDAO")
@Transactional
public class JobDaoImpl implements JobDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean createAndUpdateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteJob(int id) {
		try {
			sessionFactory.getCurrentSession().delete(selectOneJob(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Job> selectAllJob() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Job where status="+true).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Job selectOneJob(int id) {
		try {
			return (Job) sessionFactory.getCurrentSession().createQuery("from Job where id="+id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Job> selectUnapprovedJob() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Job where status="+false).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
