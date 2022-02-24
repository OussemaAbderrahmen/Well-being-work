package tn.esprit.spring.wecare.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Notification;
import tn.esprit.spring.wecare.services.NotificationServiceImpl;

@RestController
@RequestMapping("/notification")
public class NotificationController {
	@Autowired
	NotificationServiceImpl notserv;
	
	//http://localhost:8089/wecare/notificationr/add-notification
			@PostMapping("/add-notification") 
			public Notification addNotification(@RequestBody Notification n)
			 {
				
				return notserv.addNotification(n);
			}
			//http://localhost:8089/wecare/notification/update-notification
			@PutMapping("/update-notification")
			public Notification updateNotification(@RequestBody Notification n){
			
				notserv.updateNotification(n);
				return n;
			}
			//http://localhost:8089/wecare/notification/get-all-notification
			@GetMapping("/get-all-notification")
			public List<Notification> getAll(){
				List<Notification> listNotification = notserv.getAllNotification();
				return listNotification;
			}
			
			//http://localhost:8089/wecare/notification/get-notification-by-id/2
			@GetMapping("/get-notification-by-id/{notification-id}")
			public Notification getUserById(@PathVariable("notification-id") Long id){
				Notification n = notserv.getNotificationById(id);
				return n;
			}
			//http://localhost:8089/wecare/notification/delete-notification/2
			@DeleteMapping("/delete-notification/{notification-id}")
			public void deleteNotification(@PathVariable("notification-id")Long id) {
				notserv.deleteNotificationById(id);
			}
			

}
