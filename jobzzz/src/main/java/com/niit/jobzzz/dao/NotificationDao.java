package com.niit.jobzzz.dao;

import java.util.List;

import com.niit.jobzzz.model.Notification;

public interface NotificationDao {
	
	boolean createupdatenotification(Notification notification);
	boolean deletenotification(int id);
	List<Notification> selectAllNotification(String email);
	Notification selectNotification(int id);

}
