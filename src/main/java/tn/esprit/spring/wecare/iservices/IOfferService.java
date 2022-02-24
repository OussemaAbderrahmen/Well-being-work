package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Offer;
public interface IOfferService {
	public Offer addOffer(Offer o);
	public Offer updateOffer(Offer o );
	public List<Offer> getAllOffer();
	public Offer getOfferById(Long id);
	public void deleteOfferById(Long id);
}
