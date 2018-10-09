package com.primetgi.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	// create new fields
	private String emailAddress;
	private String team;

	// create a non arg constructor
	public CricketCoach() {
		System.out.println("CricketCoach: Inside non arg Constructor");
	}

	// setter method
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: Inside Setter Method - set FortuneService ");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Bowling for 15 mins - CricketCoach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortuneService();
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: Inside Setter Method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: Inside Setter Method - setTeam");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

}
