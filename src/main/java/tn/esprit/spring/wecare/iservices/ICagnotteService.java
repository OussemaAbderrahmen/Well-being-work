package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Cagnotte;
public interface ICagnotteService {

	public Cagnotte addCagnotte(Cagnotte c );
	public Cagnotte updateCagnotte(Cagnotte c);
	public List<Cagnotte> getAllCagnotte();
	public Cagnotte getCagnotteById(Long id);
	public void deleteCagnotteById(Long id);
}
