package com.primetgi.springdemo;

import org.springframework.stereotype.Component;

//Below uses Explicit BeanId 
//@Component("theTennisCoach")

//Below uses Default BeanId i.e className  'tennisCoach'
@Component()
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

}
