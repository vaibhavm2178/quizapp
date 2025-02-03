package com.sambhav.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sambhav.quizapp.model.Question;
import com.sambhav.quizapp.model.QuestionWrapper;
import com.sambhav.quizapp.model.Response;
import com.sambhav.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@GetMapping("/get/{id}")	
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
			return quizservice.getQuizQuestions(id);
		}
	@Autowired
	QuizService quizservice;

	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
	{
			return quizservice.createQuiz(category,numQ,title);

	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses ){
		
		return quizservice.calculateResult(id, responses);
		
	}

}
