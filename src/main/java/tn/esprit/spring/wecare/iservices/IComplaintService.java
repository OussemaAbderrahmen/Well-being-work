package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Complaint;

public interface IComplaintService {

	public Complaint createComplaintAndAsseigntoUser(Complaint c, Long idUser);
	public List<Complaint> getAllComplaint();
	public Complaint getComplaintById(Long id);
	public Complaint updateComplaint(Long id);
	public void deleteComplaintById(Long id);
}
