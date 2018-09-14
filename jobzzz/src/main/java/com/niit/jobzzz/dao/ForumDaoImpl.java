package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.Blog;
import com.niit.jobzzz.model.Forum;

@Repository("forumDAO")
@Transactional
public class ForumDaoImpl implements ForumDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean createAndUpdateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteForum(int id) {
		try {
			sessionFactory.getCurrentSession().delete(selectOneForum(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Forum> selectAllForum() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Forum").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Forum selectOneForum(int id) {
		try {
			return (Forum) sessionFactory.getCurrentSession().createQuery("from Forum where foid="+id).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
