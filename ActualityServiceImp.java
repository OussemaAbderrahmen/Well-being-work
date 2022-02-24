package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Publication;
import tn.esprit.spring.wecare.iservices.ActualityIservice;
import tn.esprit.spring.wecare.repositories.PublicationCommentsRepository;
import tn.esprit.spring.wecare.repositories.PublicationRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
@Slf4j
public class ActualityServiceImp implements ActualityIservice {

	
	@Autowired
	PublicationRepository PublicationRepository;
	@Autowired
	PublicationCommentsRepository PublicationCommentsRepository;
	@Autowired
	UserRepository UserRepository;
	
	
	
	@Override
	public Publication createPub(Publication pub) {
		
		return PublicationRepository.save(pub);
	}
	@Override
	public List<Publication> getAll() {
		
		return (List<Publication>)PublicationRepository.findAll();
	}
	
	@Override
	public Publication getById(Long id) {
	
			Publication pub = PublicationRepository.getById(id);
		
		return pub;
	}
	@Override
	public Publication updatePub(Publication pub) {
		
		return PublicationRepository.save(pub);
	}
	
	
	@Override
	public void deletePub(Long id) {

		PublicationRepository.deleteById(id);
	}
}
