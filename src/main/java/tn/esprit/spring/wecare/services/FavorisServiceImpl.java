package tn.esprit.spring.wecare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Activities;
import tn.esprit.spring.wecare.entities.Favoris;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.FavorisIService;
import tn.esprit.spring.wecare.repositories.ActivitéRepository;
import tn.esprit.spring.wecare.repositories.FavorisRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
public class FavorisServiceImpl implements FavorisIService {

	@Autowired
	FavorisRepository favorisrepo;
	@Autowired
	ActivitéRepository activiterepo;
	@Autowired
	UserRepository userrepo;
	
	@Override
	public void addFavorisActivity(long idActivity, long idFavoris,long idUser) {
		
		Favoris favrs= favorisrepo.findById(idFavoris).get();
		Activities act= activiterepo.findById(idActivity).get();
		User user =userrepo.findById(idUser).get();
		
		if(act.isFavorie()==true && act.getUser()==user) 
		{
			favrs.getActivities().add(act);
			favorisrepo.save(favrs);
			}
	}

}
