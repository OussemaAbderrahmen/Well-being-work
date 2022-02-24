package tn.esprit.spring.wecare.controllers;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Collaboration;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.services.CollaborationServiceImpl;
import tn.esprit.spring.wecare.services.EntrepriseServiceImpl;


@RestController
@RequestMapping("/collaboration")
public class CollaborationController {
@Autowired
CollaborationServiceImpl collaborationService;

@Autowired
EntrepriseServiceImpl entrepriseService;

//http://localhost:8089/wecare/collaboration/create-collaboration/1
	@PostMapping("/create-collaboration/{id}") 
	public Collaboration createCollaboration(@RequestBody Collaboration c,@PathVariable Long id)
	 {
		
		return collaborationService.createCollaborationAndAssignToEntreprise(c, id);
	}
	//http://localhost:8089/wecare/collaboration/get-all-collaboration
	@GetMapping("/get-all-collaboration")
	public List<Collaboration> getAll(){
		List<Collaboration> listCollaboration = collaborationService.getAllCollaboration();
		return listCollaboration;
	}
	
	
	//http://localhost:8089/wecare/collaboration/get-collaboration-by-id/{collaboration-id}
	@GetMapping("/get-collaboration-by-id/{collaboration-id}")
	public Collaboration getCollaborationById(@PathVariable("collaboration-id") Long id){
		Collaboration c= collaborationService.getCollaborationById(id);
		return c;
	}
	//http://localhost:8089/wecare/collaboration/delete-collaboration/1
	@DeleteMapping("/delete-collaboration/{collaboration-id}")
	public void deleteEntreprise(@PathVariable("collaboration-id")Long id) {
		collaborationService.deleteCollaboration(id);
	}
	

	@PutMapping("/update-collaboration")
	public Collaboration updateCollaboration(@RequestBody Collaboration cd){
		collaborationService.updateCollaboration( cd);
		return cd;
	}
	
	
	
}
