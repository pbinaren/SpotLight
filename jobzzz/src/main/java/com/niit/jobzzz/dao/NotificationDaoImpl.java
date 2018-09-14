package com.niit.jobzzz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.jobzzz.model.Notification;

@Repository("notificationDAO")
@Transactional
public class NotificationDaoImpl implements NotificationDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean createupdatenotification(Notification notification) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(notification);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletenotification(int id) {
		try {
			sessionFactory.getCurrentSession().delete(selectNotification(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Notification> selectAllNotification(String email) {
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Notification where email=" +email).list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Notification selectNotification(int id) {
		try {
			return (Notification) sessionFactory.getCurrentSession().createQuery("from Notification where notid=" +id)
					.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
