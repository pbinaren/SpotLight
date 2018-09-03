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

	public boolean deleteBlog(int blogid) {
		try {
			sessionFactory.getCurrentSession().delete(selectOneBlog(blogid));
			sessionFactory.getCurrentSession().createQuery("delete from BlogComment where blogid=" + blogid)
					.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Blog> selectAllBog() {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Blog where status=" + true + " order by blogid desc").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Blog selectOneBlog(int blogid) {
		try {
			return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where blogid=" + blogid)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Blog> selectUnapprovedBlog() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog where status=" + false).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Blog> MyBlogs(String Email) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Blog where blogAuthoremail ='" + Email + "' order by blogid desc").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
