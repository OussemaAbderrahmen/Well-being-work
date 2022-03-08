package tn.esprit.spring.wecare.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.core.credential.AzureKeyCredential;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.extern.slf4j.Slf4j;
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
import tn.esprit.spring.wecare.services.models.confidenceScores;
@Slf4j
@Service

public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	ComplaintRepository complaintRepo;
	@Autowired
	AdsRepository adRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	AnalyzeSentiment analyzeSentiment;
	@Override
	public confidenceScores createComplaintAndAsseigntoUser(Complaint c, Long idUser) throws IOException {
		
		User e = userRepo.findById(idUser).orElse(null);
		log.info(e.getFirstName());
		log.info(c.toString());
		
//		TextAnalyticsClient textAnalyticsClient = new TextAnalyticsClientBuilder()
//			    .credential(new AzureKeyCredential("7cc8098b36f04a09a0b8133203291705"))
//			    .endpoint("https://bali.cognitiveservices.azure.com/text/analytics/v3.0/sentiment")
//			    .buildClient();
		String description=c.getComplaintDescription();
//		DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(description);
//		System.out.printf("Analyzed document sentiment: %s.%n", documentSentiment.getSentiment());
//		documentSentiment.getSentences().forEach(sentenceSentiment ->
//		    System.out.printf("Analyzed sentence sentiment: %s.%n", sentenceSentiment.getSentiment()));
		
		

		c.setUser(e);
		complaintRepo.save(c);
		
		confidenceScores analyze = analyzeSentiment.analyze(description);
	return analyze;
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
	public Complaint updateComplaint(Complaint c,Long id) {
		Date d = new Date();
		Complaint cc = complaintRepo.getById(id);
		c.setStatus(true);
		c.setComplaintDate(d);
		c.setComplaintDescription(cc.getComplaintDescription());
		c.setComplaintType(cc.getComplaintType());
		c.setUsercomplaints(cc.getUsercomplaints());
		
		this.complaintRepo.save(c);
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
