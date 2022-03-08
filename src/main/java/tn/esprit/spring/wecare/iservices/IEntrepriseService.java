package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Entreprise;

public interface IEntrepriseService {

	public List<Entreprise> getAllEntreprise();
	public Entreprise createEntreprise(Entreprise e);
	public Entreprise updateEntreprise(Long id);
	public Entreprise getEntrepriseById(Long id);
	public void deleteEntreprise(Long id);
}
