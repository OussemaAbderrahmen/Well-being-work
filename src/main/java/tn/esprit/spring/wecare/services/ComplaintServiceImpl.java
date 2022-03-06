package tn.esprit.spring.wecare.services;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.DuplicateComplainers;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.entities.statComplaint;
import tn.esprit.spring.wecare.iservices.IComplaintService;
import tn.esprit.spring.wecare.repositories.AdsRepository;
import tn.esprit.spring.wecare.repositories.ComplaintRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;
@Service
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	ComplaintRepository complaintRepo;
	@Autowired
	AdsRepository adRepo;
	@Autowired
	UserRepository userRepo;
	@SuppressWarnings("deprecation")
	@Override
	public String createComplaintAndAsseigntoUser(Complaint c, Long idUser) throws IOException {
		
		User e = userRepo.findById(idUser).orElse(null);
		c.setUser(e);
		 OkHttpClient client = new OkHttpClient().newBuilder().build();

		    MediaType mediaType = MediaType.parse("application/json");
		    RequestBody body = RequestBody.create(mediaType, c.getComplaintDescription().toString());

		    Request request = new Request.Builder()
		    		.url("https://api.apilayer.com/text_to_emotion")
		    		.addHeader("apikey", "W0osvTrqOhman1PEd4oBbWB1BATBNdek")
		    		.method("POST", body)
		    		.build();
		  
		    Response response = client.newCall(request).execute();  
		    System.out.println(response.body().string());
		    complaintRepo.save(c);
		return response.body().toString();
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

	@Override
	public Complaint createComplaintAndAsseigntoAd(Complaint c, Long idAd) {


		Ads e = adRepo.findById(idAd).orElse(null);
		c.setAd(e);
		
		return complaintRepo.save(c);
		
	}
	
	@Override
	public List<DuplicateComplainers> duplicateComplainers() {
		
		return complaintRepo.getDuplicateComplainers();
	}
	
	

}
