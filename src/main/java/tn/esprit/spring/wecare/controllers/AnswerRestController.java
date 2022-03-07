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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.wecare.entities.Answers;
import tn.esprit.spring.wecare.iservices.AnswerIService;

@RestController
@RequestMapping("/answer")
public class AnswerRestController {
	
	@Autowired
	AnswerIService answerIservice;
	// http://localhost:8089/wecare/answer/get-all-answers
	@ResponseBody
	@GetMapping("/get-all-answers")
	public List<Answers> getallAnswers(){
		 return answerIservice.getallAnswers();}
	
	// http://localhost:8089/wecare/answer/get-answer/{idAnswer}
	@ResponseBody
	@GetMapping("/get-answer/{idAnswer}")
	public Answers getAnswerById(@PathVariable("idAnswer")Long id) {
		
		return answerIservice.getAnswerById(id);}
	
	// http://localhost:8089/wecare/answer/create-answer
	@ResponseBody
	@PostMapping("/create-answer")
	public void addAnswer(@RequestBody Answers answer) {
		answerIservice.addAnswer(answer);}
	
	
	// http://localhost:8089/wecare/answer/delete-answer/{id}
	@ResponseBody
	@DeleteMapping("/delete-answer/{id}")
	public void deleteAnswer(@PathVariable("id")Long id) {
		answerIservice.deleteAnswer(id);}
	
	// http://localhost:8089/wecare/answer/update-answer/{id}
	@ResponseBody
	@PutMapping("/update-answer/{id}")
	public void updateAnswer(@RequestBody Answers answer,@PathVariable("id") Long id) {
		answerIservice.updateAnswer(answer, id);}

}
