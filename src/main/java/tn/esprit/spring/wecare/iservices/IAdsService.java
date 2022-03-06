package tn.esprit.spring.wecare.iservices;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.statAdCompl;
import tn.esprit.spring.wecare.entities.statAds;

public interface IAdsService {

	public Ads createAdAndAsseigntoUser(Ads c, Long idUser);
	public List<Ads> getAllAds();
	public Ads getAdById(Long id);
	public Ads updateAd(Long id);
	public void deleteAdById(Long id);
	public Set<statAds> getstatAds();
	//public List<MostComplainer> mostComplainer();
	public List<statAdCompl> getMostAdComplainer() ;
}
