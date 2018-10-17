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
	public Coach badmintonCoach() {
		return new BadmintonCoach(happyFortuneService());
	}

	@Bean
	public FortuneService RESTFortuneService() {
		return new RESTFortuneService();
	}

	@Bean
	public Coach tableTennisCoach() {
		return new TableTennisCoach();
	}
}
