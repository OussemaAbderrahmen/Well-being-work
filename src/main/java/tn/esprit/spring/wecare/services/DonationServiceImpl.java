package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.wecare.entities.Cagnotte;
import tn.esprit.spring.wecare.entities.Donation;
import tn.esprit.spring.wecare.entities.User;
import tn.esprit.spring.wecare.iservices.IDonationService;
import tn.esprit.spring.wecare.repositories.CagnotteRepository;
import tn.esprit.spring.wecare.repositories.DonationRepsitory;
import tn.esprit.spring.wecare.repositories.UserRepository;

@Service
public class DonationServiceImpl implements IDonationService {

	@Autowired
	UserRepository userepo;
	@Autowired
	CagnotteRepository cagnotterepo;
	@Autowired
	DonationRepsitory donrepo;
	@Override
	public void affectusercagnotte(Donation d, Long idUser, Long idCagnotte) {
		User u = userepo.findById(idUser).get();
		Cagnotte c = cagnotterepo.findById(idCagnotte).get();
		
			u.getDonations().add(d);
			c.getDonations().add(d);
			d.setCagnotte(c);
			d.setUser(u);
			
				
					
			
		donrepo.save(d);
	}
	@Override
	public List<Donation> GetAllDonations() {
		
		return donrepo.findAll();
	}

	

}
