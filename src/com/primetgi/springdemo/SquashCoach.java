package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SquashCoach implements Coach {

	private FortuneService fortuneService;

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public SquashCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Pratice Squash for 1 hr";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	
}
