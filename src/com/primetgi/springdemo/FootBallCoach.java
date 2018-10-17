package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach {

	public FootBallCoach() {
		System.out.println(">> Inside No-Org Constructor -- FootBall Coach");
	}

	private FortuneService fortuneService;

	public FootBallCoach(@Qualifier("happyFortuneService") FortuneService theFortuneService) {
		System.out.println(">> Inside Org Constructor -- FootBall Coach");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Running for 5 Kms";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
