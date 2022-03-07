package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Departement;
import tn.esprit.spring.wecare.iservices.IDepartmentService;
import tn.esprit.spring.wecare.repositories.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartmentService {

	@Autowired
	DepartementRepository departementRepository;
	@Override
	public Departement createDepartement(Departement d) {
		
		return departementRepository.save(d);
	}

	@Override
	public Departement updateDepartement(Departement d, Long id) {
		Departement dd =departementRepository.findById(id).get();
		dd.setDepartementName(d.getDepartementName());
		
		return departementRepository.save(dd);
	}

	@Override
	public List<Departement> getAllDepartement() {
		
		return departementRepository.findAll();
	}

	@Override
	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);
		
	}

}
