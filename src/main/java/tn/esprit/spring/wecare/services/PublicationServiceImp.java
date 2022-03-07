package tn.esprit.spring.wecare.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.ActiveEmployeee;
import tn.esprit.spring.wecare.entities.BestAndWorstPub;
import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.Theme;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.PublicationIservice;
import tn.esprit.spring.wecare.repositories.DictionaryRepository;
import tn.esprit.spring.wecare.repositories.PublicationCommentsRepository;
import tn.esprit.spring.wecare.repositories.PublicationRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;


@Service
@Slf4j
public class PublicationServiceImp implements PublicationIservice{
	
	@Autowired
	PublicationRepository PublicationRepository;
	@Autowired 
	PublicationCommentsRepository PublicationCommentsRepository;
	@Autowired
	DictionaryRepository DictionaryRepository;
	@Autowired 
	UserRepository 	UserRepository;

	@Override
	public Publication createPub(Publication pub, Long idUser) {
	User user = UserRepository.findById(idUser).orElse(null);
		String text = pub.getPublicationDescription();
		String title = pub.getPublicationTitle();
		List<Dictionary> badwords =  DictionaryRepository.findAll();
		int compteur = 0;
		for(int i =0 ; i < badwords.size(); i++)
		{
			if(text.contains(badwords.get(i).getWord()) || title.contains(badwords.get(i).getWord()))
			{
				
				compteur ++;
			}
		}
		
		if(compteur>0) {
			
			System.out.println("This message was blocked because a bad word was found."
					+ "If you believe this word should not be blocked, please message support.");
			return null;
		}
		else 
		{
		pub.setUser(user);
		pub.setPublicationDate(new Date());
		return PublicationRepository.save(pub);
		}	
	}

	@Override
	public List<Publication> findAllBypubTime() {
		return	 PublicationRepository.findAllByDate();
	}

	@Override
	public Publication updatePub(Publication pub, Long id) {
		Publication pubs = PublicationRepository.findById(id).get();
		String text = pub.getPublicationDescription();
		String title = pub.getPublicationTitle();
		List<Dictionary> badwords =  DictionaryRepository.findAll();
		int compteur = 0;
		for(int i =0 ; i < badwords.size(); i++)
		{
			if(text.contains(badwords.get(i).getWord()) || title.contains(badwords.get(i).getWord()))
			{
				
				compteur ++;
			}
		}
		
		if(compteur>0) {
			
			System.out.println("This message was blocked because a bad word was found."
					+ "If you believe this word should not be blocked, please message support.");
			return null;
		}
		else 
		{
			pubs.setPublicationTitle(pub.getPublicationTitle());
			pubs.setPublicationDescription(pub.getPublicationDescription());
			pubs.setImage(pub.getImage());
			
			}
			
			return PublicationRepository.save(pubs)	;
			}

	@Override
	public void deletePub(Long id) {
		PublicationRepository.deleteById(id);
		
	}

	@Override
	public void likeAPub(Long id, Long idUser) {
		tn.esprit.spring.wecare.entities.User user = UserRepository.findById(idUser).get();
		Publication pub = PublicationRepository.findById(id).get();
		Set<tn.esprit.spring.wecare.entities.User> LU = pub.getLikes();
		if(pub.getDislikes().contains(user))
		{
			pub.getDislikes().remove(user);
			LU.add(user);
			pub.setLikes(LU);
			
		}
		else 
			if(pub.getLikes().contains(user)) {
				
				pub.getLikes().remove(user);
			}
		else {LU.add(user);}
		PublicationRepository.save(pub);	
	
	}

	@Override
	public void DislikeAPub(Long id, Long idUser) {
		tn.esprit.spring.wecare.entities.User user = UserRepository.findById(idUser).get();
		Publication pub = PublicationRepository.findById(id).get();
		Set<tn.esprit.spring.wecare.entities.User> LU = pub.getDislikes();
		if(pub.getLikes().contains(user))
		{
			pub.getLikes().remove(user);
			LU.add(user);
			pub.setDislikes(LU);
			
		}

		else {LU.add(user);}
		PublicationRepository.save(pub);	
	
		
	}

	@Override
	@Transactional
	public List<Publication> GetPublicationsByName(String name) {
		tn.esprit.spring.wecare.entities.User user = UserRepository.findByFirstName(name);
		List<Publication> l = PublicationRepository.findByUser(user);
		if(user.getFirstName() == name  || user.getLastName()==name )
		{user.setPublications(l);}
		return  PublicationRepository.findByUser(user);
	}

	@Override
	public List<Publication> GetPublicationsByTheme(Theme theme) {
		// TODO Auto-generated method stub
		return PublicationRepository.findByTheme(theme);
	}

	@Override
	public BestAndWorstPub BestPubeachMonth() {

	log.info("in method");
	BestAndWorstPub p = PublicationRepository.bestpub();	
		log.info("out of method");
		return p;
				
	
	}

	@Override
	public BestAndWorstPub WorstPubeachMonth() {
		log.info("in method");
		BestAndWorstPub p = PublicationRepository.worstpub();	
			log.info("out of method");
			return p;
	}

	@Override
	public ActiveEmployeee activeusereachMonth() {
		log.info("in method");
		ActiveEmployeee p = PublicationRepository.activePerson();
			log.info("out of method");
			return p;
	}
	
	

	

}
