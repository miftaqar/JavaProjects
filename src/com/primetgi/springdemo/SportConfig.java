package com.primetgi.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.primetgi.springdemo")
public class SportConfig {

	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach BadmintonCoach() {
		BadmintonCoach badmintonCoach = new BadmintonCoach(happyFortuneService());
		return badmintonCoach;
	}
}
