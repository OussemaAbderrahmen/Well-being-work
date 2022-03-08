package tn.esprit.spring.wecare.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.entities.Donation;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IDonationService;
import tn.esprit.spring.wecare.repositories.CagnotteRepository;
import tn.esprit.spring.wecare.repositories.DonationRepository;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
public class DonationServiceImpl implements IDonationService {

	@Autowired
	UserRepository userepo;
	@Autowired
	CagnotteRepository cagnotterepo;
	@Autowired
	DonationRepository donrepo;

	@Override
	public String affectusercagnotte(Donation d, Long idUser, Long idCagnotte) {
		String msg = "";
		d.setDateDonation(new Date());
		User u = userepo.findById(idUser).get();
		Cagnotte c = cagnotterepo.findById(idCagnotte).get();
		double i = c.getMoneyCollected();
		msg=" Old value of collected money "+i ;
		c.setMoneyCollected(i + d.getAmount());
		double a = c.getMoneyCollected();
		u.getDonations().add(d);
		c.getDonations().add(d);
		d.setCagnotte(c);
		d.setUser(u);
		donrepo.save(d);
		msg+=" \nNew value of the collected money "+ a ;
		return msg ; 
	}

	@Override
	public List<Donation> GetAllDonations() {
		return donrepo.findAll();
	}

}
