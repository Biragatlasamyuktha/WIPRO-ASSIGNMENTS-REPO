package com.wipro.hp.quizappmonorepo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.hp.quizappmonorepo.entities.Question;
import com.wipro.hp.quizappmonorepo.enums.Category;
import com.wipro.hp.quizappmonorepo.enums.DifficultyLevel;
import com.wipro.hp.quizappmonorepo.services.QuestionService;




@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@PostMapping("/addNewQuestion")
	public Question addQuestion(@RequestBody Question question) {
        return questionService.save(question);
    }
	
	@GetMapping("/getQuestionById/{id}")
    public Question getQuestionById(@PathVariable Integer id) {
        return questionService.getQuestionById(id);
    }
	
    
    @GetMapping("/getAllQuestions")
    public Page<Question> getAllQuestionsPage(Pageable pageable) {
        return questionService.findAllQuestions(pageable);
    }

    @GetMapping("/getBYCatDiff")
    public List<Question> findByCategoryAndDifficultyLevel(
        @RequestParam Category category,
        @RequestParam DifficultyLevel difficultyLevel) {
        return questionService.findByCategoryAndDifficultyLevel(category, difficultyLevel);
    }
    
    @PatchMapping("/patchQuestionById/{id}")
    public Question patch(@PathVariable Integer id, @RequestBody Question question) {
        return questionService.patchQuestion(id, question);
    }
    
    @DeleteMapping("/deleteQuestionById/{id}")
	public String deleteQuestion(@PathVariable Integer id) {
		
		questionService.deleteQuestionById(id);
		return "Question Deleted Successfully";
	}

}
