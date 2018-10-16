package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice Running for 3 Hrs";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
