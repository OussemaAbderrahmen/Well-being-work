package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.entities.Donation;
import tn.esprit.spring.wecare.services.DonationServiceImpl;

@RestController
@RequestMapping("/donation")
public class DonationController {
	@Autowired
	DonationServiceImpl donserv;
	
	
	@PostMapping("/add-donation/{idUser}/{idCagnotte}")
	public void affecterUserCagnotte(@RequestBody Donation d,@PathVariable("idUser") Long idUser, @PathVariable("idCagnotte") Long idCagnotte){
		donserv.affectusercagnotte(d, idUser, idCagnotte);
	}
	
	
	
	//http://localhost:8089/wecare/donation/get-all-donation
		@GetMapping("/get-all-donation")
		public List<Donation> getAll(){
			List<Donation> listDonation= donserv.GetAllDonations();
			return listDonation;
		}

}
