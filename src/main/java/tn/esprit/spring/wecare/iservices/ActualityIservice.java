package tn.esprit.spring.wecare.iservices;


import java.util.List;



import tn.esprit.spring.wecare.entities.Publication;

public interface ActualityIservice {
	
	 public Publication createPub (Publication pub);
	 
	 public List<Publication> getAll();
	 
	 public Publication getById( Long id);
	 
	 public  Publication updatePub (Publication pub);
	 
	 public void deletePub( Long id);
	 
	 
	 
	 

}
