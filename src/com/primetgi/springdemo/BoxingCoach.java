package com.primetgi.springdemo;

import org.springframework.stereotype.Component;

@Component()
public class BoxingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice Kicking for 30 mins";
	}

}
