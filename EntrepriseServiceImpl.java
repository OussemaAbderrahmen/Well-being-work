package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.iservices.IEntrepriseService;
import tn.esprit.spring.wecare.repositories.EntrepriseRepository;
@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
	@Autowired
	EntrepriseRepository entrepriseRepo;

	@Override
	public List<Entreprise> getAllEntreprise() {
		
		return entrepriseRepo.findAll();
	}

	@Override
	public Entreprise createEntreprise(Entreprise e) {
		
		return entrepriseRepo.save(e);
	}

	@Override
	public Entreprise updateEntreprise(Long id) {
		Entreprise e = entrepriseRepo.findById(id).orElse(null);
		entrepriseRepo.save(e);
		return e;
	}

	@Override
	public Entreprise getEntrepriseById(Long id) {
		
		return entrepriseRepo.findById(id).get();
	}

	@Override
	public void deleteEntreprise(Long id) {

		entrepriseRepo.deleteById(id);
	}

}
