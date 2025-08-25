package com.wipro.hp.quizappmonorepo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.hp.quizappmonorepo.entities.Question;
import com.wipro.hp.quizappmonorepo.enums.Category;
import com.wipro.hp.quizappmonorepo.enums.DifficultyLevel;

public interface QuestionService {

	Question save(Question question);

	List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel);

	Question patchQuestion(Integer id, Question question);

	void deleteQuestionById(Integer id);

	Question getQuestionById(Integer id);

	Page<Question> findAllQuestions(Pageable pageable);

	

}
