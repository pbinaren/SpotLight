package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.BlogComment;

@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDAo {

	@Autowired
	SessionFactory sessionFactory;

	public boolean createAndUpdateBlog(BlogComment blogcomment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(blogcomment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteBlogComment(int id) {
		try {
			BlogComment blogcomment =(BlogComment) sessionFactory.getCurrentSession().createQuery("from BlogComment where id="+id).uniqueResult();
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<BlogComment> selectmyBogComment(int blogid) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Blog").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
