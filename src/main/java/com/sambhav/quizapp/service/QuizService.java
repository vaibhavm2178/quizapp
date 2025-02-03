package com.sambhav.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sambhav.quizapp.model.Question;
import com.sambhav.quizapp.model.QuestionWrapper;
import com.sambhav.quizapp.model.Quiz;
import com.sambhav.quizapp.model.Response;
import com.sambhav.quizapp.repository.QuestionDAO;
import com.sambhav.quizapp.repository.QuizDao;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class QuizService {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	Quiz quiz;
	@Autowired
	QuestionDAO questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		quiz.setTitle(title);
		List<Question> questions = questionDao.findRandomQuestionByCategory(category, numQ);
		
	quiz.setQuestions(questions);
	quizDao.save(quiz);
		return new ResponseEntity<String>("Quiz created", HttpStatus.CREATED);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List <QuestionWrapper> questionsForUser = new ArrayList<QuestionWrapper>();
		for(Question q : questionsFromDB ) {
			QuestionWrapper qp = new QuestionWrapper(q.getId(), q.getQuestion_title(),q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4()) ;
			questionsForUser.add(qp);
		}
		
		
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions() ;
		int right =0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRight_answer())) {
				right++;
			}
			i++;
			
			
		}
		
		
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

}
