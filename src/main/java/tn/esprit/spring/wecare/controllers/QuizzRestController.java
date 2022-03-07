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

import tn.esprit.spring.wecare.entities.Quizz;
import tn.esprit.spring.wecare.entities.Userdto;
import tn.esprit.spring.wecare.iservices.QuizIService;

@RestController
@RequestMapping("/quizz")
public class QuizzRestController {
	
	
	@Autowired
	QuizIService quizzIservice;

	// http://localhost:8089/wecare/quizz/get-all-quizz
	@GetMapping("/get-all-quizz")
	public List<Quizz> getallQuizz(){
		return quizzIservice.getallQuizz();}
	
	// http://localhost:8089/wecare/quizz/get-quizz-by-id/{id}

	@GetMapping("/get-quizz-by-id/{id}")
	public Quizz getQuizzById(@PathVariable("id") Long id) {
		return quizzIservice.getQuizzById(id);}
	
	
	// http://localhost:8089/wecare/quizz/createquizz
	@PostMapping("/createquizz")
	public void addQuizz(@RequestBody Quizz quizz) {
		quizzIservice.addQuizz(quizz);}
	
	// http://localhost:8089/wecare/quizz/deletequizz/{id}

	@DeleteMapping("/deletequizz/{id}")
	public void deleteQuizz(@PathVariable("id") Long id) {
		quizzIservice.deleteQuizz(id);}
	
	// http://localhost:8089/wecare/quizz/updatequizz/{id}

	@PutMapping("/updatequizz/{id}")
	public void updateQuizz(@RequestBody Quizz quizz,@PathVariable("id") Long id) {
		quizzIservice.updateQuizz(quizz, id);}
	
	// http://localhost:8089/wecare/quizz/best-score

	@GetMapping("/best-score")
	public Userdto Bestscoreforuser() {
		return quizzIservice.Bestscoreforuser();
	}
}
