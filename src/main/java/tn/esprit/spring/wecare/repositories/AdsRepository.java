package tn.esprit.spring.wecare.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.wecare.entities.Ads;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.entities.MostComplainer;
import tn.esprit.spring.wecare.entities.statAdCompl;
import tn.esprit.spring.wecare.entities.statAds;
import tn.esprit.spring.wecare.entities.statComplaint;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Long> {
	
	
	@Query(value="select count(ad_id) as nbr_ads ,type from ads where type='Image'"
			+ " union select count(ad_id) as nbr_ads ,type from ads where type='Text'"
			+ " union select count(ad_id) as nbr_ads ,type from ads where type='Video'",nativeQuery=true)
	public Set<statAds> getStatAds(); 
	
//	l'utilisateur qui a fait le plus de reclamation sur une pub afin de savoir l'utilisateur le plus active avec son @email qui identifie l'utilisateur on peut savoir notre cible
//	et on peut ameliorer notre marketing par les reclamtion reçu  
	@Query(value ="select users.email as user, ads.ad_description, count(ad_id) as nbr_ads from ads ads left join user users on users.user_id=ads.user_user_id", nativeQuery=true)
	public List <statAdCompl> getMostAdComplainer();
	
	
	

}
