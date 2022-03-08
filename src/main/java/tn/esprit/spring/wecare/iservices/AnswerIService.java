package tn.esprit.spring.wecare.iservices;

import java.util.List;

import tn.esprit.spring.wecare.entities.Answers;

public interface AnswerIService {
	
	public List<Answers> getallAnswers();
	public Answers getAnswerById(Long id);
	public void addAnswer(Answers answer);
	public void deleteAnswer(Long id);
	public void updateAnswer(Answers answer,Long id);

}
