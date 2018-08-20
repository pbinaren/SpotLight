package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDaoImpl implements BlogDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean createAndUpdateBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlog(int id) {
		try {
			sessionFactory.getCurrentSession().delete(selectOneBlog(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Blog> selectAllBog() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status="+true).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Blog selectOneBlog(int id) {
		try {
			return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where id="+id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Blog> selectUnapprovedBlog() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status="+false).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
