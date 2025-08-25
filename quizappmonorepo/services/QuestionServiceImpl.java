package com.wipro.hp.quizappmonorepo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.hp.quizappmonorepo.entities.Question;
import com.wipro.hp.quizappmonorepo.enums.Category;
import com.wipro.hp.quizappmonorepo.enums.DifficultyLevel;
import com.wipro.hp.quizappmonorepo.exceptions.ResourceNotFoundException;
import com.wipro.hp.quizappmonorepo.repo.QuestionRepo;





@Service

public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private  QuestionRepo questionRepo;

	@Override
	public Question save(Question question) {
		
		return questionRepo.save(question);
	}

	

	@Override
	public Question getQuestionById(Integer id) {

		return questionRepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Question not found with id " + id));
	}
	
	@Override
	public Page<Question> findAllQuestions(Pageable pageable) {
		
		return questionRepo.findAll(pageable);
	}

	
	@Override
	public Question patchQuestion(Integer id, Question question) {
		Question existing = questionRepo.findById(id)
	            .orElseThrow(()-> new ResourceNotFoundException("Question not found with id " + id));

	        if (question.getQuestionTitle() != null) existing.setQuestionTitle(question.getQuestionTitle());
	        if (question.getOption1() != null) existing.setOption1(question.getOption1());
	        if (question.getOption2() != null) existing.setOption2(question.getOption2());
	        if (question.getOption3() != null) existing.setOption3(question.getOption3());
	        if (question.getOption4() != null) existing.setOption4(question.getOption4());
	        if (question.getCorrectAnswer() != null) existing.setCorrectAnswer(question.getCorrectAnswer());
	        if (question.getDifficultyLevel() != null) existing.setDifficultyLevel(question.getDifficultyLevel());
	        if (question.getCategory() != null) existing.setCategory(question.getCategory());

	        return questionRepo.save(existing);
	    
	}

	@Override
	public void deleteQuestionById(Integer id) {
		if (!questionRepo.existsById(id)) {
            throw new ResourceNotFoundException("Cannot delete. Question not found with id " + id);
        }
		questionRepo.deleteById(id);
	}

	

	@Override
	public List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel) {
		
		return questionRepo.findByCategoryAndDifficultyLevel(category, difficultyLevel);
	}

	

	
	
	 

}
