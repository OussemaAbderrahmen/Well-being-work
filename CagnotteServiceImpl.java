package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.iservices.ICagnotteService;
import tn.esprit.spring.wecare.repositories.CagnotteRepository;

@Service
public class CagnotteServiceImpl implements ICagnotteService{
	
	@Autowired
	CagnotteRepository cagnotteRepo;

	@Override
	public Cagnotte addCagnotte(Cagnotte c) {
		return cagnotteRepo.save(c);
	}

	@Override
	public Cagnotte updateCagnotte(Cagnotte c) {
		return this.cagnotteRepo.save(c);
	}

	@Override
	public List<Cagnotte> getAllCagnotte() {
		return cagnotteRepo.findAll();
	}

	@Override
	public Cagnotte getCagnotteById(Long id) {
		return cagnotteRepo.getById(id);
	}

	@Override
	public void deleteCagnotteById(Long id) {
		cagnotteRepo.deleteById(id);
		
	}

}
