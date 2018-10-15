package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BoxingCoach implements Coach {

	
	private FortuneService fortuneService;

	public BoxingCoach() {
		System.out.println(">> Inside Default Constructor - Boxing Coach >>");
	}

	// define a setter method
	@Autowired
	@Qualifier("happyFortuneService")
	public void setFortuneServie(FortuneService theFortuneService) {
		System.out.println(">> Inside Setter Method - Boxing Coach >>");
		fortuneService = theFortuneService;
	}

	@Autowired
	@Qualifier("happyFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> Inside doSomeCrazyStuff method - BoxingCoach");
	}

	public void doSomeSeriousStuff() {
		System.out.println(">> Inside doSomeSeriousStuff method - BoxingCoach");
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
