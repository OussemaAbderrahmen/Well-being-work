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
import tn.esprit.spring.wecare.entities.Collaboration;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.statComplaint;
import tn.esprit.spring.wecare.services.ComplaintServiceImpl;
import java.io.*;
import okhttp3.*;

@RestController
@RequestMapping("/complaint")
@Slf4j
public class ComplaintController {
	
	@Autowired
	ComplaintServiceImpl complaintService;
	
	//http://localhost:8089/wecare/complaint/create-complaint/1
		@PostMapping("/create-complaint/{idUser}") 
		public Complaint createComplaintAndAsseigntoUser(@RequestBody Complaint c ,@PathVariable Long idUser)
		 {
			
			return complaintService.createComplaintAndAsseigntoUser(c, idUser);
		}
		
		
		
		//http://localhost:8089/wecare/complaint/get-all-complaints
		@GetMapping("/get-all-complaints")
		public List<Complaint> getAllComplaint(){
			List<Complaint> listComplaint = complaintService.getAllComplaint();
			return listComplaint;
		}
		
		
		//http://localhost:8089/wecare/entreprise/get-complaint-by-id/{complaint-id}
		@GetMapping("/get-complaint-by-id/{complaint-id}")
		public Complaint getComplaintById(@PathVariable("complaint-id") Long id){
			Complaint c= complaintService.getComplaintById(id);
			return c;
		}
		//http://localhost:8089/wecare/complaint/delete-complaint/{complaint-id}
		@DeleteMapping("/delete-complaint/{complaint-id}")
		public void deleteEntreprise(@PathVariable("complaint-id")Long id) {
			complaintService.deleteComplaintById(id);
		}
		

		@PutMapping("/update-complaint/{complaintId}")
		public Complaint updateComplaint(@PathVariable("complaintId") Long complaintId){
			Complaint c = this.complaintService.getComplaintById(complaintId);
			complaintService.updateComplaint(complaintId);
			return c;
		}
		
		@PostMapping("/emotions") 
		public void emotionComplaint(@RequestBody String description) throws IOException
		 {

//			    HttpServletRequest request = HttpServletRequest.get("https://api.apilayer.com/text_to_emotion").addHeader("apikey", "W0osvTrqOhman1PEd4oBbWB1BATBNdek").connectTimeout(120000);
//	            String res = request.body();
//	            return new ResponseEntity<>(res, HttpStatus.OK);
			OkHttpClient client = new OkHttpClient().newBuilder().build();

		    MediaType mediaType = MediaType.parse("text/plain");

		    Request request = new Request.Builder()
		      .url("https://api.apilayer.com/text_to_emotion")
		      .addHeader("apikey", "W0osvTrqOhman1PEd4oBbWB1BATBNdek")
		      
		      .build();
		    Response response = client.newCall(request).execute();
		    log.info("response:"+ response);
	    
			
		}
		
		
		//http://localhost:8089/wecare/complaint/mostcomplainer
		@GetMapping("/mostcomplainer")
		public List<MostComplainer> mostComplainer(){
			return complaintService.mostComplainer();
		}
		
		//http://localhost:8089/wecare/complaint/statcomplaint
				@GetMapping("/statcomplaint")
				public Set<statComplaint> getStatComplaint(){
					
					return complaintService.getstatComplains();
				}
}
