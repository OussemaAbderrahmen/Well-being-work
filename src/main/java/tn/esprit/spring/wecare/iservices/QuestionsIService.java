package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Questions;


public interface QuestionsIService {

	
	public List<Questions> getallQuestions();
	public Questions getQuestionById(Long id);
	public void addQuestion(Questions qst);
	public void deleteQuestion(Long id);
	public void updateQuestion(Questions qst,Long id);
}
