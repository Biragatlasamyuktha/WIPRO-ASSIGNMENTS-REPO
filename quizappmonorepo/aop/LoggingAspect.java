package com.wipro.hp.quizappmonorepo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;






@Aspect
@Component //object creation 
@Slf4j
public class LoggingAspect {

	@Before("execution(* com.spring.quiz.controllers.QuestionController.addQuestion(..))")
	public void logbefore() {
		//log.info("logging something before addNewQuestion endpoint ");
	}
}
