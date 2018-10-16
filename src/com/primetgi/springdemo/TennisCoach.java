package com.primetgi.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Below uses Explicit BeanId 
//@Component("theTennisCoach")

//Below uses Default BeanId i.e className  'tennisCoach'
@Component
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService theFortuneService) {
		System.out.println(">> Inside Param Constructor - Tennis Coach >>");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	//define init method
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> Inside doMyStartUpStuff - TennisCoach >>");
	}
	
	//define destroy method
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> Inside doMyCleanUpStuff - TennisCoach >>");
	}
}
