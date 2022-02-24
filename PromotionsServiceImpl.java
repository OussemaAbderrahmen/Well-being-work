package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Promotions;
import tn.esprit.spring.wecare.iservices.IPromotionService;
import tn.esprit.spring.wecare.repositories.PromotionRepository;

@Service
public class PromotionsServiceImpl implements IPromotionService{

	@Autowired
	PromotionRepository promorepository;
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

}
