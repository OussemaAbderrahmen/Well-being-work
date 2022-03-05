package tn.esprit.spring.wecare.iservices;

import tn.esprit.spring.wecare.entities.Dictionary;

public interface DictionairyIservice {

	public Dictionary AddWord(Long idWord , Long idUser);
	
	public Dictionary findAllWords();
	
}
