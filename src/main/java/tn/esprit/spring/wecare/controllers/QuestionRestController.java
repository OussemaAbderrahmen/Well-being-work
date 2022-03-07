package tn.esprit.spring.wecare.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Questions;
import tn.esprit.spring.wecare.iservices.QuestionsIService;

@RestController
@RequestMapping("/questionquizz")
public class QuestionRestController {
	
	@Autowired
	QuestionsIService questionIservice;

	
	// http://localhost:8089/wecare/questionquizz/get-all-questions

	@GetMapping("/get-all-questions")
	public List<Questions> getallQuestions(){
		return questionIservice.getallQuestions();}
	
	// http://localhost:8089/wecare/questionquizz/get-question-by-id/{id}
	@GetMapping("/get-question-by-id/{id}")
	public Questions getQuestionById(@PathVariable("id") Long id) {
		return questionIservice.getQuestionById(id);}
	
	// http://localhost:8089/wecare/questionquizz/create-question
	@PostMapping("/create-question")
	public void addQuestion(@RequestBody Questions qst) {
		questionIservice.addQuestion(qst);}
	
	
	// http://localhost:8089/wecare/questionquizz/delete-question/{id}

	@DeleteMapping("/delete-question/{id}")
	public void deleteQuestion(@PathVariable("id")Long id) {
		questionIservice.deleteQuestion(id);}
	
	// http://localhost:8089/wecare/questionquizz/update-question/{id}

	@PutMapping("/update-question/{id}")
	public void updateQuestion(@RequestBody Questions qst,@PathVariable("id") Long id) {
		questionIservice.updateQuestion(qst, id);
	}
}
