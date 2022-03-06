package tn.esprit.spring.wecare.controllers;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Collaboration;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.statAdCompl;
import tn.esprit.spring.wecare.entities.statAds;
import tn.esprit.spring.wecare.entities.statComplaint;
import tn.esprit.spring.wecare.services.AdsServiceImpl;
import tn.esprit.spring.wecare.services.ComplaintServiceImpl;
import java.io.*;
import okhttp3.*;

@RestController
@RequestMapping("/ads")
@Slf4j
public class AdsController {
	
	@Autowired
	AdsServiceImpl adService;
	
	//http://localhost:8089/wecare/ads/create-ad/1
		@PostMapping("/create-ad/{idUser}") 
		public Ads createComplaintAndAsseigntoUser(@RequestBody Ads c ,@PathVariable Long idUser)
		 {
			
			return adService.createAdAndAsseigntoUser(c, idUser);
		}
		
		
		
		//http://localhost:8089/wecare/ads/get-all-ads
		@GetMapping("/get-all-ads")
		public List<Ads> getAllAds(){
			List<Ads> listAds = adService.getAllAds();
			return listAds;
		}
		
		
		//http://localhost:8089/wecare/ads/get-ad-by-id/{ad-id}
		@GetMapping("/get-ad-by-id/{ad-id}")
		public Ads getAdById(@PathVariable("complaint-id") Long id){
			Ads c= adService.getAdById(id);
			return c;
		}
		//http://localhost:8089/wecare/complaint/delete-ad/{ad-id}
		@DeleteMapping("/delete-ad/{ad-id}")
		public void deleteAd(@PathVariable("ad-id")Long id) {
			adService.deleteAdById(id);
		}
		

		@PutMapping("/update-ad/{adId}")
		public Ads updateAd(@PathVariable("adId") Long adId){
			Ads c = this.adService.getAdById(adId);
			adService.updateAd(adId);
			return c;
		}
		

		//http://localhost:8089/wecare/ads/statads
		@GetMapping("/statads")
		public Set<statAds> getStatAds(){
			
			return adService.getstatAds();
		}
		
		//http://localhost:8089/wecare/ads/mostadcomplainer
		@GetMapping("/mostadcomplainer")
		public List<statAdCompl> mostComplainer(){
			return adService.getMostAdComplainer();
		}
		
		
		
	
}
