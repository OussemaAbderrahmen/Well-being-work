package tn.esprit.spring.wecare.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Notification;
import tn.esprit.spring.wecare.iservices.INotificationService;
import tn.esprit.spring.wecare.repositories.NotificationRepository;

@Service
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	NotificationRepository notificationrepository;
	
	
	@Override
	public Notification addNotification(Notification n) {
		
		return notificationrepository.save(n);
	}

	@Override
	public Notification updateNotification(Notification n) {
		
		return this.notificationrepository.save(n);
	}

	@Override
	public List<Notification> getAllNotification() {
		
		return (List<Notification>) notificationrepository.findAll();
	}

	@Override
	public Notification getNotificationById(Long id) {
		
		return notificationrepository.findById(id).get();
	}

	@Override
	public void deleteNotificationById(Long id) {
		notificationrepository.deleteById(id);
		
	}

}
