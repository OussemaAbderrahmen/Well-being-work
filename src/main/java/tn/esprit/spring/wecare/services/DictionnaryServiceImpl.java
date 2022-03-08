package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Dictionary;
import tn.esprit.spring.wecare.repositories.DictionaryRepository;
@Service
public class DictionnaryServiceImpl {

	@Autowired
	DictionaryRepository dictionaryRepository;
	
	public Dictionary addWord(Dictionary d){
		return dictionaryRepository.save(d);
	}
	public List<Dictionary> getBadWords(){
		return dictionaryRepository.findAll();
	}
}
