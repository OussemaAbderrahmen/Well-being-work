package tn.esprit.spring.wecare.services;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Notification;
import tn.esprit.spring.wecare.iservices.INotificationService;
import tn.esprit.spring.wecare.repositories.NotificationRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
@Slf4j
public class NotificationServiceImpl implements INotificationService {

	@Autowired
	NotificationRepository notificationrepository;
	UserRepository userrepo;
	
	
	
	
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

	@Override
	public String verifnotification( Long id) {
		
		Notification n = notificationrepository.findById(id).get();
		 String m = "";
		
		
				if (id==n.getNotificationId() && n.getUserNotif().equals("Accept"))
				{
						
						m="Notification Valid";
						
					
				}
				else 
					m ="Notification Invalid";
				
				return m;
		
	}

	@Override
	public String statisticsNotification() {
		List<Notification> n = notificationrepository.findAll();
		int s = n.size();
		int l = 0;
		int nl = 0;
		  for(Notification no : n ){
			  if(no.getEtat()==true){
				  l++;
			  }
			  else if (no.getEtat()==false){
				  
				  nl++;
			  }
			  
		  }
		  log.info("l :"+l);
		  log.info("ln :"+nl);
		  double suml = (l/s)*100;
		  double sumnl=(nl/s)*100;
		  
		  
		return "notifications lues : " +suml+ "% \n notification non lues : " +sumnl+ "%";
		
	}

	
	

	


	

	


		
	}

	

	

	

	
	

	

	
	
	


