package com.sambhav.quizapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sambhav.quizapp.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
