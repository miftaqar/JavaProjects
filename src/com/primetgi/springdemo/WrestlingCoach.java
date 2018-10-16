package com.primetgi.springdemo;

import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements Coach {

	private FortuneService fortuneService;
	
	public WrestlingCoach() {
		System.out.println(">> Inside Constructor - WrestlingCoach >>");
	}
	
	public WrestlingCoach(FortuneService theFortuneService) {
		System.out.println("Inside Param Constructor - WrestlingCoach");
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {

		return "Practice Push Ups of 30 reps";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
