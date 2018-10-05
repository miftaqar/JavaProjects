package com.primetgi.springdemo;

public class BaseBallCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on Batting Practice - BaseBallCoach";
	}
}
