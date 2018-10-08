package com.primetgi.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	public TrackCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a 5k Hard Run";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: "+fortuneService.getFortuneService();
	}

}
