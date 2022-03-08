package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Activities;
import tn.esprit.spring.wecare.iservices.ActiviteIService;
import tn.esprit.spring.wecare.repositories.ActivitéRepository;

@Service
public class ActivitéServiceImpl implements ActiviteIService {

	@Autowired
	ActivitéRepository activitieRepo;
	
	@Override
	public List<Activities> getallActivities() {
		
		return (List<Activities>)activitieRepo.findAll();}

	@Override
	public Activities getActivitiesById(Long id) {
		 return activitieRepo.findById(id).get();}

	@Override
	public void addActivity(Activities act) {
    
		activitieRepo.save(act);
	}

	@Override
	public void deleteActivity(Long id) {
		activitieRepo.delete(activitieRepo.findById(id).get());}

	@Override
	public void updateActivity(Activities act,Long id) {
		
		Activities activité= activitieRepo.findById(id).get();
		activité.setActivitieName(act.getActivitieName());
		activité.setFavorie(act.isFavorie());
		activité.setImage(act.getImage());
		activitieRepo.save(activité);
	}

	

}
