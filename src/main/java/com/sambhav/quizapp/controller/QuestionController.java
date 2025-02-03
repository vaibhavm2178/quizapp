package com.sambhav.quizapp.controller;

import com.sambhav.quizapp.model.Question;
import com.sambhav.quizapp.service.QuestionService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

	/*
	 * public QuestionController(QuestionService questionService) {
	 * this.questionService = questionService; }
	 */


    @GetMapping("/allquestions")
    public ResponseEntity<List <Question>> getAllQuestions(){
         return questionService.getAllQuestion();
    }
    
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
    	return questionService.getQuestionsByCategory(category);
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
    	 
    	return questionService.addQuestion(question);
    	
    }

    
}
