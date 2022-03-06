package tn.esprit.spring.wecare.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
