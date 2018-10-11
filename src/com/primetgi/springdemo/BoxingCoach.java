package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class BoxingCoach implements Coach {

	private FortuneService fortuneService;

	public BoxingCoach() {
		System.out.println(">> Inside Default Constructor - Boxing Coach >>");
	}
	
	//define a setter method
	@Autowired
	public void setFortuneServie(FortuneService theFortuneService) {
		System.out.println(">> Inside Setter Method - Boxing Coach >>");
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Kicking for 30 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
