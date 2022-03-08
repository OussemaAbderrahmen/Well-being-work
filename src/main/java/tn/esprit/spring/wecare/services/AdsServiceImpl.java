package tn.esprit.spring.wecare.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.Entreprise;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.entities.statAdCompl;
import tn.esprit.spring.wecare.entities.statAds;
import tn.esprit.spring.wecare.entities.statComplaint;
import tn.esprit.spring.wecare.iservices.IAdsService;
import tn.esprit.spring.wecare.iservices.IComplaintService;
import tn.esprit.spring.wecare.repositories.AdsRepository;
import tn.esprit.spring.wecare.repositories.ComplaintRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;
@Service
@Slf4j
@EnableScheduling
public class AdsServiceImpl implements IAdsService {

	@Autowired
	AdsRepository adRepo;
	@Autowired
	UserRepository userRepo;

	@Override
	public Ads createAdAndAsseigntoUser(Ads c, Long idUser) {
		
		User e = userRepo.findById(idUser).orElse(null);
    	c.setUser(e);
		
		return adRepo.save(c);
	}
	@Override
	public List<Ads> getAllAds() {
			return adRepo.findAll();
	}
	@Override
	public Ads getAdById(Long id) {
		return adRepo.findById(id).get();
	}
@Scheduled(fixedDelay=5000)
	public Ads getAdByIdScheduled() throws SQLException {
		  String mysqlUrl = "jdbc:mysql://localhost/wecarefinal";
	      Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
	      Statement stmt = con.createStatement();
	      String query = "select count(*) from Ads";
	      //Executing the query
	      ResultSet rs = stmt.executeQuery(query);
	      //Retrieving the result 
	      rs.next();
	      //count is the length of ads
	      
	      long count = rs.getInt(1);
	      log.info("Ads length :"+ count);
	      Random random = new Random();   
	      long number = (long)(random.nextDouble()*count); 
	      if (number==0){          
	    	  number= number+1;
	    	}

	      log.info("The ad is :"+ number );
	      log.info( "The ad's name "+adRepo.findById(number).get().getAdDescription());
			return adRepo.findById(number).get();

	      
//	     log.info(adService.getAdById(number).toString()); 
	}
	@Override
	public Ads updateAd(Long id) {
		Ads c = adRepo.findById(id).orElse(null);
		adRepo.save(c);
		return c;
	}
	@Override
	public void deleteAdById(Long id) {
		adRepo.deleteById(id);
		
	}
	@Override
	public Set<statAds> getstatAds() {
		
		return adRepo.getStatAds();
	}
	@Override
	public List<statAdCompl> getMostAdComplainer() {
		
		return adRepo.getMostAdComplainer();
	}
	

}
