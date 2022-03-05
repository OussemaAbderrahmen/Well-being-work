package tn.esprit.spring.wecare.iservices;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.wecare.entities.ActiveEmployeee;
import tn.esprit.spring.wecare.entities.BestAndWorstPub;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.Theme;

public interface PublicationIservice {

	 public Publication createPub (Publication pub, Long idUser);
	 
	 public  List<Publication> findAllBypubTime();
	 
	 public  Publication  updatePub (Publication pub, Long id);
	 
	 public void deletePub( Long id);
	 
	 public void likeAPub(Long id , Long idUser);
	 
	 public void DislikeAPub(Long id , Long idUser);
	 
	public List<Publication> GetPublicationsByName(String name  );//search 
	
	public List<Publication> GetPublicationsByTheme(Theme theme);
	
	public BestAndWorstPub BestPubeachMonth();
	
	public BestAndWorstPub WorstPubeachMonth();
	
	public ActiveEmployeee activeusereachMonth();
	 
	 
	//public List<Publication> getAllpubs();

	 
	
	 
	

	
	
}
