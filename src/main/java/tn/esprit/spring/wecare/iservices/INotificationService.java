package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Notification;





public interface INotificationService {
	
	
	
public Notification addNotification(Notification n);
public Notification updateNotification(Notification n );
public List<Notification> getAllNotification();
public Notification getNotificationById(Long id);
public void deleteNotificationById(Long id);
}
