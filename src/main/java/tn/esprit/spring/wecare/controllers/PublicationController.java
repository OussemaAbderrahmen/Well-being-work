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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.ActiveEmployeee;
import tn.esprit.spring.wecare.entities.BestAndWorstPub;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.Theme;
import tn.esprit.spring.wecare.iservices.PublicationIservice;

@RestController
@RequestMapping("/actuality")
public class PublicationController {
	@Autowired
	PublicationIservice PublicationIservice;
	
	//http://localhost:8089/wecare/actuality/create-pub/{id-User}
	
	@PostMapping("/create-pub/{id-User}") 
	public Publication createPub(@RequestBody Publication pub,@PathVariable("id-User") Long idUser)
	 {
		
		return PublicationIservice.createPub(pub, idUser);
	}
	
	@GetMapping("/get-allpubsdate")
	public List<Publication> findAllBypubTime(){
		List<Publication> listPubs = PublicationIservice.findAllBypubTime();
		return listPubs;
	}
	
	@DeleteMapping("/remove-pub/{pub-id}")
	public void deletePub(@PathVariable("pub-id")Long id) {
		PublicationIservice.deletePub(id);
	}
	
	@PutMapping("/update-pub/{pub-id}") 
	public Publication updatePub(@RequestBody Publication pub, @PathVariable("pub-id")Long id )
	 {
		
		return PublicationIservice.updatePub(pub, id);
	}
	
	@PutMapping("/likepost/{idPost}/{idUser}")
	public void likeAPub(@PathVariable("idPost")Long id, @PathVariable("idUser")Long idUser)
	{	
		PublicationIservice.likeAPub(id, idUser);
		
	}
	
	@PutMapping("/Dislikepost/{idPost}/{idUser}")
	public void DislikeAPub(@PathVariable("idPost")Long id, @PathVariable("idUser")Long idUser)
	{	
		PublicationIservice.DislikeAPub(id, idUser);
		
	}
	@GetMapping("/searchbyname/{name}")
	@ResponseBody
	public List<Publication> GetPublicationsByName(@PathVariable("name") String name) {
	
		return 	PublicationIservice.GetPublicationsByName(name);
	}


	@GetMapping("/searchbytheme/{theme}")
	@ResponseBody
	public List<Publication> GetPublicationsByTheme(@PathVariable("theme")Theme theme){
		 return PublicationIservice.GetPublicationsByTheme(theme);
		
	}
	
	@GetMapping("/bestpubbymonth")
	public BestAndWorstPub BestPubeachMonth() {
		return PublicationIservice.BestPubeachMonth();
	}
	
	@GetMapping("/worstpubbymonth")
	public BestAndWorstPub WorstPubeachMonth() {
		return PublicationIservice.WorstPubeachMonth();
	}
	
	@GetMapping("/activeUser")
	public ActiveEmployeee activeusereachMonth(){
		return PublicationIservice.activeusereachMonth();
	}
}

