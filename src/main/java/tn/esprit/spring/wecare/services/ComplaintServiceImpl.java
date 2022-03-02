package tn.esprit.spring.wecare.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.entities.statComplaint;
import tn.esprit.spring.wecare.iservices.IComplaintService;
import tn.esprit.spring.wecare.repositories.ComplaintRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;
@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	ComplaintRepository complaintRepo;
	@Autowired
	UserRepository userRepo;
	@Override
	public Complaint createComplaintAndAsseigntoUser(Complaint c, Long idUser) {
		
		User e = userRepo.findById(idUser).orElse(null);
		c.setUser(e);
		
		return complaintRepo.save(c);
	}

	@Override
	public List<Complaint> getAllComplaint() {
	
		return complaintRepo.findAll();
	}

	@Override
	public Complaint getComplaintById(Long id) {
		return complaintRepo.findById(id).get();
	}

	@Override
	public Complaint updateComplaint(Long id) {
		Complaint c = complaintRepo.findById(id).orElse(null);
		complaintRepo.save(c);
		return c;
	}

	@Override
	public void deleteComplaintById(Long id) {
		complaintRepo.deleteById(id);
		
	}

	@Override
	public List<MostComplainer> mostComplainer() {
		
		return complaintRepo.mostComplainer();
	}
	
	
	public Set<statComplaint> getstatComplains() {
		
		return complaintRepo.getStatComplaint();
	}
	

}
