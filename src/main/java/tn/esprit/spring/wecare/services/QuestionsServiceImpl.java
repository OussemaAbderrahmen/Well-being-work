package tn.esprit.spring.wecare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.wecare.entities.Questions;
import tn.esprit.spring.wecare.iservices.QuestionsIService;
import tn.esprit.spring.wecare.repositories.QuestionRepository;

@Service
public class QuestionsServiceImpl implements QuestionsIService {

	@Autowired
	QuestionRepository questionrepository;

	@Override
	public List<Questions> getallQuestions() {
		return (List<Questions>) questionrepository.findAll();}

	@Override
	public Questions getQuestionById(Long id) {
		return questionrepository.findById(id).get();}

	@Override
	public void addQuestion(Questions qst) {
		questionrepository.save(qst);}

	@Override
	public void deleteQuestion(Long id) {
		questionrepository.delete(questionrepository.findById(id).get());}

	@Override
	public void updateQuestion(Questions qst,Long id) {
		Questions question = questionrepository.findById(id).get();
		question.setQuestions(qst.getQuestions());
		questionrepository.save(question);
	}

}
