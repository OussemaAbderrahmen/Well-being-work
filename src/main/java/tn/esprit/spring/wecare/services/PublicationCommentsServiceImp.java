package tn.esprit.spring.wecare.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.CommentPost;
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
@Slf4j


public class PublicationCommentsServiceImp implements PublicationCommentIservice{
	
	@Autowired
	PublicationRepository publicationRepository;
	@Autowired 
	PublicationCommentsRepository publicationCommentsRepository;
	@Autowired
	DictionaryRepository dictionaryRepository;
	@Autowired 
	UserRepository 	userRepository;
	
	@Override
	public PublicationComments addCommPublicationComments(PublicationComments PubCom, Long id, Long idUser) {
	
			User user = userRepository.findById(idUser).get();
			Publication pub = publicationRepository.findById(id).get();
			String text = PubCom.getComment();
			List<Dictionary> badwords =  dictionaryRepository.findAll();
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
			return publicationCommentsRepository.save(PubCom);}
		}


	@Override
	public PublicationComments UpdateComment(PublicationComments PubCom, Long idComm) {
		String text = PubCom.getComment();
		List<Dictionary> badwords =  dictionaryRepository.findAll();
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
		PublicationComments PubComs = publicationCommentsRepository.findById(idComm).get();
		PubComs.setComment(PubCom.getComment());
		PubComs.setCommentImage(PubCom.getComment());
		
	}
		return publicationCommentsRepository.save(PubCom);
		}


	@Override
	public void likeAComment(Long idComm, Long idUser) {
		User user = userRepository.findById(idUser).get();
		PublicationComments PubComs = publicationCommentsRepository.findById(idComm).get();
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
		publicationCommentsRepository.save(PubComs);	
		
		
	}

	@Override
	public void DislikeAComment(Long idComm, Long idUser) {
		PublicationComments cp = publicationCommentsRepository.findById(idComm).orElseGet(null);
		User u = userRepository.findById(idUser).orElseGet(null);
		Set<User> l = cp.getDislikes();
		if(cp.getLikes().contains(u))
		{
			cp.getLikes().remove(u);
			l.add(u);
			cp.setDislikes(l);
			}
		else
		{	l.add(u);}
		publicationCommentsRepository.save(cp);
}
	
	@Override
	public void deleteComment(Long idComm) {
		publicationCommentsRepository.deleteById(idComm);
		
	}


	@Override
	public List<PublicationComments> getAllPublCommentsbydate(Long id) {
		Publication pub = publicationRepository.findById(id).get();
		pub.getPublicationcomments();
		
		return publicationCommentsRepository.findAllByDate(id);
	}
	
	

}
