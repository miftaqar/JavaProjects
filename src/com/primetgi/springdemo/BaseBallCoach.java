package com.primetgi.springdemo;

public class BaseBallCoach implements Coach {

	//define a private field
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseBallCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on Batting Practice - BaseBallCoach";
	}

	@Override
	public String getDailyFortune() {
		//use fortuneService to call getFortuneService
		
		return fortuneService.getFortuneService();
	}
}
