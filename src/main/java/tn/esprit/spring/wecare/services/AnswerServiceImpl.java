package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Answers;
import tn.esprit.spring.wecare.iservices.AnswerIService;
import tn.esprit.spring.wecare.repositories.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerIService {

	@Autowired
	AnswerRepository answerRepo;

	public List<Answers> getallAnswers(){
		return (List<Answers>) answerRepo.findAll();}
	
	public Answers getAnswerById(Long id) {
		return answerRepo.findById(id).get();}
	
	public void addAnswer(Answers answer) {
		answerRepo.save(answer);
	}
	
	public void deleteAnswer(Long id) {
		answerRepo.delete(answerRepo.findById(id).get());
	}
	public void updateAnswer(Answers answer,Long id) {
		Answers ans= answerRepo.findById(id).get();
		ans.setAnswer(answer.getAnswer());
		ans.setCorrectAnswer(answer.getCorrectAnswer());
		answerRepo.save(ans);
	}

}
