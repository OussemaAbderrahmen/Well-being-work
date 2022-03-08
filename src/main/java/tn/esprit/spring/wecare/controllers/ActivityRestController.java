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

import tn.esprit.spring.wecare.entities.Activities;
import tn.esprit.spring.wecare.iservices.ActiviteIService;

@RestController
@RequestMapping("/activity")
public class ActivityRestController {
	

	@Autowired
	ActiviteIService activiteIservice;
	
	// http://localhost:8089/wecare/activity/get-all-activities
	@GetMapping("/get-all-activities")
	public List<Activities> getallActivities(){
		 return activiteIservice.getallActivities();}
	
	// http://localhost:8089/wecare/activity/get-activity-by-id/{idActivity}
	@GetMapping("/get-activity-by-id/{idActivity}")
	public Activities getActivitiesById(@PathVariable("idActivity")Long id) {
		
		return activiteIservice.getActivitiesById(id);
		}
	
	// http://localhost:8089/wecare/activity/create-activity
	@PostMapping("/create-activity")
	public void addActivity(@RequestBody Activities act) {
		activiteIservice.addActivity(act);
		}
	
	// http://localhost:8089/wecare/activity/delete-activity/{id}
	@DeleteMapping("/delete-activity/{id}")
	public void deleteActivity(@PathVariable("id")Long id) {
		activiteIservice.deleteActivity(id);}
	
	// http://localhost:8089/wecare/activity/update-activity/{id}
	@PutMapping("/update-activity/{id}")
	public void updateActivity(@RequestBody Activities act,@PathVariable("id") Long id) {
		activiteIservice.updateActivity(act, id);}
	

}
