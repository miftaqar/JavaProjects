package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {

		// load the Spring Configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from Spring Container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

		// Call methods on bean
		System.out.println(theCoach.getDailyWorkout());

		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();

	}

}
