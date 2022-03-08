package tn.esprit.spring.wecare.services;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Promotions;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IPromotionService;
import tn.esprit.spring.wecare.repositories.NotificationRepository;
import tn.esprit.spring.wecare.repositories.PromotionRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
public class PromotionsServiceImpl implements IPromotionService{

	@Autowired
	PromotionRepository promorepository;
	@Autowired
	NotificationRepository notifrepo;
	@Autowired
	UserRepository userrepo;
	
	@Autowired
	EmailSenderService eService;
	
	@Override
	public Promotions addPromotions(Promotions p) {
		
		return promorepository.save(p);
	}

	@Override
	public Promotions updatePromotions(Promotions p) {
		return this.promorepository.save(p);
	}

	@Override
	public List<Promotions> getAllPromotions() {
		
		return promorepository.findAll();
	}

	@Override
	public Promotions getPromotionsById(Long id) {
		return promorepository.getById(id);
	}

	@Override
	public void deletePromotionsById(Long id) {
		promorepository.deleteById(id);
		
	}

	@Override
	public String Evaluation(Long id) {
		Promotions p = promorepository.findById(id).get();
		int nbpoints;
		String m ="";
		
		if (id==p.getPromotionId() && p.getUserReact() >= 30){
			
		  
			nbpoints = p.getUserReact();
			
			return m="membre actif \n le nombre des points  est :  " +nbpoints  ;
		}
		else 
			nbpoints = p.getUserReact();
			m="membre inactif \n le nombre des points  est :  " +nbpoints  ;
		
		return m ;
	}

	

	//@Scheduled(cron="001**")
	@Scheduled(fixedDelay=10000)
	
		public void mailAvis(){
		
			List<User> users = new ArrayList<>();
			users=userrepo.findAll();
			for(User uu : users){
				eService.sendSimpleEmail(uu.getEmail(), "Ya Ghali AAndek Promotion rak rbehtt voyage hayhay", "Promotion");
			
		}
	}
		
	
	
	
	
		
		
		
		
	}
	
	
	
	
	

	

	
		

	
	
	

	
	
	
	
	


