package tn.esprit.spring.wecare.iservices;


import java.util.List;

import tn.esprit.spring.wecare.entities.Donation;

public interface IDonationService {
	public String affectusercagnotte(Donation d,Long idUser, Long idCagnotte);
	public List<Donation> GetAllDonations();
}
