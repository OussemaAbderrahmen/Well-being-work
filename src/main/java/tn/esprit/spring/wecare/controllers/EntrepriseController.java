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

import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.services.EntrepriseServiceImpl;
@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {
@Autowired
EntrepriseServiceImpl entrepriseService;

//http://localhost:8089/wecare/entreprise/create-entreprise
	@PostMapping("/create-entreprise") 
	public Entreprise createEntreprise(@RequestBody Entreprise e)
	 {
		
		return entrepriseService.createEntreprise(e);
	}
	//http://localhost:8089/wecare/entreprise/update-entreprise/{entrepriseId}
	@PutMapping("/update-entreprise/{entrepriseId}")
	public Entreprise updateEntreprise(@PathVariable("entrepriseId") Long entrepriseId){
		Entreprise e = this.entrepriseService.getEntrepriseById(entrepriseId);
		entrepriseService.updateEntreprise(entrepriseId);
		return e;
	}
	//http://localhost:8089/wecare/entreprise/get-all-entreprise
	@GetMapping("/get")
	public List<Entreprise> getAll(){
		List<Entreprise> listentreprise = entrepriseService.getAllEntreprise();
		return listentreprise;
	}
	
	//http://localhost:8089/wecare/entreprise/get-entreprise-by-id/{entreprise-id}
	@GetMapping("/get-entreprise-by-id/{entreprise-id}")
	public Entreprise getEntrepriseById(@PathVariable("entreprise-id") Long id){
		Entreprise e= entrepriseService.getEntrepriseById(id);
		return e;
	}
	//http://localhost:8089/wecare/entreprise/delete-entreprise/{entreprise-id}
	@DeleteMapping("/delete-entreprise/{entreprise-id}")
	public void deleteEntreprise(@PathVariable("entreprise-id")Long id) {
		entrepriseService.deleteEntreprise(id);
	}
	
	

}
