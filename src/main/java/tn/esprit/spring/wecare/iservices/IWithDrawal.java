package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.WithDrawal;

public interface IWithDrawal {
	public String addDrawal(WithDrawal d, Long idCagnotte);
	public WithDrawal UpdateDrawal(WithDrawal d);
	public List<WithDrawal> ListDrawal();
	public void deleteDrawal(Long id );

}