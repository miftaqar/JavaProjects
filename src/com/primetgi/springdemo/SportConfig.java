package com.primetgi.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.primetgi.springdemo")
@PropertySource("classpath:sports.properties")
public class SportConfig {

	//define bean for SadFortuneService
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define bean for SquashCoach
	@Bean
	public Coach squashCoach() {
		return new SquashCoach(sadFortuneService());
	}
	
	@Bean
	public FortuneService luckyFortuneService() {
		return new LuckyFortuneService();
	}
	
	@Bean
	public Coach wrestlingCoach() {
		WrestlingCoach wrestlingCoach = new WrestlingCoach(luckyFortuneService());
		
		return wrestlingCoach;
	}
	
	@Bean 
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach gymCoach() {
		return new GymCoach();
	}
  }
