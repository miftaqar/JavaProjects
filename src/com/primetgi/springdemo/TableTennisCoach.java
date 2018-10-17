package com.primetgi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TableTennisCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;

	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	public TableTennisCoach() {
		System.out.println(">> TT Coach Constructor >>");
	}

	@Autowired
	@Qualifier("RESTFortuneService")
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> Inside doSomeCrazyStuff Method -- TT Coach >> ");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice Spinning Volley Today";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
