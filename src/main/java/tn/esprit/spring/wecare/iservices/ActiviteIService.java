package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Activities;

public interface ActiviteIService {
	
	
	public List<Activities> getallActivities();
	public Activities getActivitiesById(Long id);
	public void addActivity(Activities act);
	public void deleteActivity(Long id);
	public void updateActivity(Activities act,Long id);
}
