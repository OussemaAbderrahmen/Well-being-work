package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Quizz;
import tn.esprit.spring.wecare.entities.Userdto;
import tn.esprit.spring.wecare.iservices.QuizIService;
import tn.esprit.spring.wecare.repositories.QuizRepository;

@Service
public class QuizServiceImpl implements QuizIService {

	@Autowired
	QuizRepository quizzrepository;
	
	
	@Override
	public List<Quizz> getallQuizz() {
		return (List<Quizz>) quizzrepository.findAll();}

	@Override
	public Quizz getQuizzById(Long id) {
		return quizzrepository.findById(id).get();}

	@Override
	public void addQuizz(Quizz quizz) {
    quizzrepository.save(quizz);}

	@Override
	public void deleteQuizz(Long id) {
		quizzrepository.delete(quizzrepository.findById(id).get());
    		
	}

	@Override
	public void updateQuizz(Quizz quizz,Long id) {
		Quizz qz= quizzrepository.findById(id).get();
		qz.setQuizzTitle(quizz.getQuizzTitle());
		qz.setQuizzDescription(quizz.getQuizzDescription());
		qz.setQuizzResult(quizz.getQuizzResult());
		quizzrepository.save(qz);
		
	}
	public Userdto Bestscoreforuser() {
		return quizzrepository.Bestscoreforuser();
	}


}
