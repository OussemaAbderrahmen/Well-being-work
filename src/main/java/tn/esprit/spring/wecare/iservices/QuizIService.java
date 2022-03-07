package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Quizz;
import tn.esprit.spring.wecare.entities.Userdto;

public interface QuizIService {
	
	public List<Quizz> getallQuizz();
	public Quizz getQuizzById(Long id);
	public void addQuizz(Quizz quizz);
	public void deleteQuizz(Long id);
	public void updateQuizz(Quizz quizz,Long id);
	public Userdto Bestscoreforuser();

}
