package com.wipro.hp.quizappmonorepo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data//
//@AllArgsConstructor//
//@NoArgsConstructor//
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String quizTitle;
	@ManyToMany
	private List<Question> questions;
	

	
	

	public Quiz() {
		super();
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getQuizTitle() {
		return quizTitle;
	}





	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}





	public List<Question> getQuestions() {
		return questions;
	}





	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}





	

}
