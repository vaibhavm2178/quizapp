package com.sambhav.quizapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String category;
    @Column(name = "difficulty_level")
    private String difficulty_level;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    @Column(name = "question_title")
    private String question_title;
    @Column(name = "right_answer")
    private String right_answer;
    @Version
    private Integer version;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDifficulty_level() {
		return difficulty_level;
	}
	public void setDifficulty_level(String difficulty_level) {
		this.difficulty_level = difficulty_level;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getQuestion_title() {
		return question_title;
	}
	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}
	public String getRight_answer() {
		return right_answer;
	}
	public void setRight_answer(String right_answer) {
		this.right_answer = right_answer;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Question(Integer id, String category, String difficulty_level, String option1, String option2,
			String option3, String option4, String question_title, String right_answer, Integer version) {
		super();
		this.id = id;
		this.category = category;
		this.difficulty_level = difficulty_level;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.question_title = question_title;
		this.right_answer = right_answer;
		this.version = version;
	}
	public Question() {
		super();
	}
	

}
