package tn.esprit.spring.wecare.services;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Collaboration;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.iservices.ICollaborationService;
import tn.esprit.spring.wecare.repositories.CollaborationRepository;
import tn.esprit.spring.wecare.repositories.EntrepriseRepository;
@Service
public class CollaborationServiceImpl implements ICollaborationService {
	@Autowired
	CollaborationRepository collaborationRepo;
	@Autowired
	EntrepriseRepository entrepriseRepo;

	@Override
	public List<Collaboration> getAllCollaboration() {
		return collaborationRepo.findAll();
	}

	@Override
	public Collaboration getCollaborationById(Long id) {
		
		return collaborationRepo.findById(id).get();
		
	}

	@Override
	public Collaboration createCollaborationAndAssignToEntreprise(Collaboration c, Long id) {
		Entreprise e = entrepriseRepo.findById(id).orElse(null);
		e.getCollaborations().add(c);
		c.setEntreprise(e);
		return collaborationRepo.save(c);
		 
	}

	@Override
	public Collaboration updateCollaboration(Long id) {
		Collaboration c = collaborationRepo.findById(id).orElse(null);
		collaborationRepo.save(c);
		return c;
	}

	@Override
	public void deleteCollaboration(Long id) {
		collaborationRepo.deleteById(id);
		
	}

}
