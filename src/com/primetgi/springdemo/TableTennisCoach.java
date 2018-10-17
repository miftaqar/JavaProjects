package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;
	
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Spinning Volley Today";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
