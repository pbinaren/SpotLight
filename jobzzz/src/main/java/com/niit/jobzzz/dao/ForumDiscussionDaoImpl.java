package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.BlogComment;
import com.niit.jobzzz.model.ForumDiscussion;

@Repository("forumDiscussionDAO")
@Transactional
public class ForumDiscussionDaoImpl implements ForumDiscussionDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean createAndUpdateFDiscussion(ForumDiscussion forumDiscussion) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumDiscussion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteForumDiscussion(int id) {
		try {
			sessionFactory.getCurrentSession().delete(selectOneForumDiscussion(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ForumDiscussion> selectForumDiscussion(int foid) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from ForumDiscussion where foid=" + foid + " order by foid desc").list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ForumDiscussion selectOneForumDiscussion(int id) {
		try {
			ForumDiscussion forumDiscussion =(ForumDiscussion) sessionFactory.getCurrentSession().createQuery("from ForumDiscussion where fdid="+id).uniqueResult();
			return forumDiscussion;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
