package com.wipro.hp.quizappmonorepo.services;

import java.util.List;

import com.wipro.hp.quizappmonorepo.entities.QuestionWrapper;
import com.wipro.hp.quizappmonorepo.entities.Quiz;
import com.wipro.hp.quizappmonorepo.entities.Response;
import com.wipro.hp.quizappmonorepo.enums.Category;
import com.wipro.hp.quizappmonorepo.enums.DifficultyLevel;

public interface QuizService {

	Quiz createQuiz(Category category, DifficultyLevel difficultyLevel, String quizTitle);

	List<QuestionWrapper> getQuizQuestions(Integer id);

	Integer	calculateResult(int id, List<Response> responses);

}
