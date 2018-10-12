package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	
	private FortuneService fortuneService;

	public CricketCoach() {
		System.out.println(">> Inside Default Constructor -- CricketCoach >>");
	}
	@Override
	public String getDailyWorkout() {
		return "Practice Bowling for 2 hrs";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
