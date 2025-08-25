package com.wipro.hp.quizappmonorepo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.hp.quizappmonorepo.entities.Quiz;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
