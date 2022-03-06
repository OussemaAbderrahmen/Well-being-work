package tn.esprit.spring.wecare.iservices;

import java.io.IOException;
import java.util.List;

import okhttp3.Response;
import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.DuplicateComplainers;
import tn.esprit.spring.wecare.entities.MostComplainer;

public interface IComplaintService {

	public String createComplaintAndAsseigntoUser(Complaint c, Long idUser) throws IOException;
	public Complaint createComplaintAndAsseigntoAd(Complaint c, Long idAd);

	public List<Complaint> getAllComplaint();
	public Complaint getComplaintById(Long id);
	public Complaint updateComplaint(Long id);
	public void deleteComplaintById(Long id);
	public List<MostComplainer> mostComplainer();
	public List<DuplicateComplainers> duplicateComplainers();
}
