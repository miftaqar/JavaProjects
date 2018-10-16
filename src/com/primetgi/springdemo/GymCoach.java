package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GymCoach implements Coach {

	private FortuneService fortuneService;

	// define a setter method
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> Inside Setter Method - Fortune Service >>");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Practice Biceps today";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
