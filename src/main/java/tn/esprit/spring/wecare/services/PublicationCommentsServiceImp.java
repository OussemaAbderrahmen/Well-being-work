package tn.esprit.spring.wecare.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.entities.PublicationComments;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.PublicationCommentIservice;
import tn.esprit.spring.wecare.repositories.DictionaryRepository;
import tn.esprit.spring.wecare.repositories.PublicationCommentsRepository;
import tn.esprit.spring.wecare.repositories.PublicationRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;
@Service

public class PublicationCommentsServiceImp implements PublicationCommentIservice{
	@Autowired
	PublicationRepository PublicationRepository;
	@Autowired
	PublicationCommentsRepository PublicationCommentsRepository;
	@Autowired
	UserRepository UserRepository;
	@Autowired
	DictionaryRepository DictionaryRepository;	

	
	@Override
	public PublicationComments addCommPublicationComments(PublicationComments PubCom, Long id, Long idUser) {
	
			User user = UserRepository.findById(idUser).get();
			Publication pub = PublicationRepository.findById(id).get();
			String text = PubCom.getComment();
			List<Dictionary> badwords =  DictionaryRepository.findAll();
			int compteur = 0;
			for(int i =0 ; i < badwords.size(); i++)
			{
				if(text.contains(badwords.get(i).getWord()))
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
			PubCom.setUser(user);
			PubCom.setPublication(pub);
			return PublicationCommentsRepository.save(PubCom);}
		}


	@Override
	public PublicationComments UpdateComment(PublicationComments PubCom, Long idComm) {
		String text = PubCom.getComment();
		List<Dictionary> badwords =  DictionaryRepository.findAll();
		int compteur = 0;
		for(int i =0 ; i < badwords.size(); i++)
		{
			if(text.contains(badwords.get(i).getWord()))
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
		PublicationComments PubComs = PublicationCommentsRepository.findById(idComm).get();
		PubComs.setComment(PubCom.getComment());
		PubComs.setCommentImage(PubCom.getComment());
		
	}
		return PublicationCommentsRepository.save(PubCom);
		}


	@Override
	public void likeAComment(Long idComm, Long idUser) {
		User user = UserRepository.findById(idUser).get();
		PublicationComments PubComs = PublicationCommentsRepository.findById(idComm).get();
		Set<User> LU = PubComs.getLikes();
		if(PubComs.getDislikes().contains(user))
		{
			PubComs.getDislikes().remove(user);
			LU.add(user);
			PubComs.setLikes(LU);
		}
		else 
			if(PubComs.getLikes().contains(user)) {
				
				PubComs.getLikes().remove(user);
			}
		else {LU.add(user);}
		PublicationCommentsRepository.save(PubComs);	
		
		
	}

	@Override
	public void DislikeAComment(Long idComm, Long idUser) {
		User user = UserRepository.findById(idUser).get();
		PublicationComments PubComs = PublicationCommentsRepository.findById(idComm).get();
		Set<User> LU = PubComs.getDislikes();
		if(PubComs.getLikes().contains(user))
		{
			PubComs.getLikes().remove(user);
			LU.add(user);
			PubComs.setDislikes(LU);
		}
		

		else {
			LU.add(user);
			PublicationCommentsRepository.save(PubComs);	
		}
}
	
	@Override
	public void deleteComment(Long idComm) {
		PublicationCommentsRepository.deleteById(idComm);
		
	}


	@Override
	public List<PublicationComments> getAllPublCommentsbydate(Long id) {
		Publication pub = PublicationRepository.findById(id).get();
		pub.getPublicationcomments();
		
		return PublicationCommentsRepository.findAllByDate(id);
	}
}
