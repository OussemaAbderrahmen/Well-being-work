package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Offer;
import tn.esprit.spring.wecare.iservices.IOfferService;
import tn.esprit.spring.wecare.repositories.OfferRepository;

@Service
public class OfferServiceImpl implements IOfferService {

	@Autowired
	OfferRepository REPOFF;
	@Override
	public Offer addOffer(Offer o) {
		return REPOFF.save(o);
	}

	@Override
	public Offer updateOffer(Offer o) {
		
		return this.REPOFF.save(o);
	}

	@Override
	public List<Offer> getAllOffer() {
		
		return REPOFF.findAll();
	}

	@Override
	public Offer getOfferById(Long id) {
		
		return REPOFF.findById(id).get();
	}

	@Override
	public void deleteOfferById(Long id) {
		REPOFF.deleteById(id);
		
	}

	
}
