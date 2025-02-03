package com.sambhav.quizapp.repository;

import com.sambhav.quizapp.model.Question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
	 //List<Question> findAll();
	
	List <Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM question q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQ ", nativeQuery=true)
	List<Question> findRandomQuestionByCategory(String category, int numQ);
}
