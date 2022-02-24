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
import tn.esprit.spring.wecare.entities.Promotions;
import tn.esprit.spring.wecare.services.PromotionsServiceImpl;


@RestController
@RequestMapping("/promotion")
public class PromotionController {

	
	@Autowired
	PromotionsServiceImpl promotionServ;

	//http://localhost:8089/wecare/promotion/add-promotion
		@PostMapping("/add-promotion") 
		public Promotions addPromotion(@RequestBody Promotions p)
		 {
			
			return promotionServ.addPromotions(p);
		}
		//http://localhost:8089/wecare/promotion/update-promotion
		@PutMapping("/update-promotion")
		public Promotions updatePromotions(@RequestBody Promotions p){
			
			
			return promotionServ.updatePromotions(p);
		}
		//http://localhost:8089/wecare/promotion/get-all-promotion
		@GetMapping("/get-all-promotion")
		public List<Promotions> getAll(){
			List<Promotions> listPromo = promotionServ.getAllPromotions();
			return listPromo;
		}
		
		//http://localhost:8089/wecare/promotion/get-promotion-by-id/2
		@GetMapping("/get-promotion-by-id/{promotion-id}")
		public Promotions getPromotionById(@PathVariable("promotion-id") Long id){
		 
			return promotionServ.getPromotionsById(id);
		}
		//http://localhost:8089/wecare/promotion/delete-promotion/2
		@DeleteMapping("/delete-promotion/{promotion-id}")
		public void deletePromotion(@PathVariable("promotion-id")Long id) {
			promotionServ.deletePromotionsById(id);
		}
}
