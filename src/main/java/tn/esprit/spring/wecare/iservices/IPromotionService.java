package tn.esprit.spring.wecare.iservices;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;

import tn.esprit.spring.wecare.entities.Promotions;


public interface IPromotionService {

	public Promotions addPromotions(Promotions p );
	public Promotions updatePromotions(Promotions p);
	public List<Promotions> getAllPromotions();
	public Promotions getPromotionsById(Long id);
	public void deletePromotionsById(Long id);
	public String Evaluation (Long id );
	//public float statistics (Long id);
	
	
	
}
