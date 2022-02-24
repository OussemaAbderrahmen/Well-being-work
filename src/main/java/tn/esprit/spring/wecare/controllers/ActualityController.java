package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.iservices.ActualityIservice;

@RestController
@RequestMapping("/actuality")
public class ActualityController {
	
	@Autowired
	ActualityIservice 	ActualityIservice;
	
	
	@PostMapping("/create-pub") 
	public Publication createPub(@RequestBody Publication pub)
	 {
		
		return ActualityIservice.createPub(pub);
	}
	
	@GetMapping("/get-allpubs")
	public List<Publication> getAll(){
		List<Publication> listPubs = (List<Publication>)ActualityIservice.getAll();
		return listPubs;
	}
	
	@GetMapping("/get-pub/{pub-id}")
	public Publication getById(@PathVariable("pub-id")Long id) {
		
		return ActualityIservice.getById(id);
	}
	
	@PostMapping("/update-pub") 
	public Publication updatePub(@RequestBody Publication pub)
	 {
		
		return ActualityIservice.updatePub(pub);
	}
	
	@DeleteMapping("/remove-pub/{pub-id}")
	public void deletePub(@PathVariable("pub-id")Long id) {
		ActualityIservice.deletePub(id);
	}
	

}
