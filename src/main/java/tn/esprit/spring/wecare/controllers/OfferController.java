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

import tn.esprit.spring.wecare.entities.Offer;
import tn.esprit.spring.wecare.services.OfferServiceImpl;

@RestController
@RequestMapping("/Offer")
public class OfferController {
	@Autowired
	OfferServiceImpl 	servoff;
	//http://localhost:8089/wecare/Offer/add-Offer
	@PostMapping("/add-Offer") 
	public Offer addOffer(@RequestBody Offer o)
	 {
		
		return servoff.addOffer(o);
	}
	//http://localhost:8089/wecare/Offer/update-Offer
	@PutMapping("/update-Offer")
	public Offer updateOffer(@RequestBody Offer o){
	
		servoff.updateOffer(o);
		return o;
	}
	//http://localhost:8089/wecare/Offer/get-all-Offer
	@GetMapping("/get-all-Offer")
	public List<Offer> getAll(){
		List<Offer> listOffer = servoff.getAllOffer();
		return listOffer;
	}
	
	//http://localhost:8089/wecare/Offer/get-Offer-by-id/2
	@GetMapping("/get-Offer-by-id/{Offer-id}")
	public Offer getOfferById(@PathVariable("Offer-id") Long id){
		Offer n = servoff.getOfferById(id);
		return n;
	}
	//http://localhost:8089/wecare/Offer/delete-Offer/2
	@DeleteMapping("/delete-Offer/{Offer-id}")
	public void deleteOffer(@PathVariable("Offer-id")Long id) {
		servoff.deleteOfferById(id);
	}

}
