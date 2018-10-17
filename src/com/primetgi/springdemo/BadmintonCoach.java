package com.primetgi.springdemo;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

	private FortuneService fortuneService;

	public BadmintonCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Back Hand Volley today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
