package com.sambhav.quizapp.service;

import com.sambhav.quizapp.model.Question;
import com.sambhav.quizapp.repository.QuestionDAO;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService  {
    @Autowired
    QuestionDAO questionDao;



    public ResponseEntity<List<Question>> getAllQuestion () {
    	try {
        return new ResponseEntity(questionDao.findAll(),HttpStatus.OK);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }



	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity(questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}


	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		try {
		questionDao.save(question);
		return new ResponseEntity("Added", HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Error Occured!", HttpStatus.BAD_REQUEST);
		
		
	}
}
