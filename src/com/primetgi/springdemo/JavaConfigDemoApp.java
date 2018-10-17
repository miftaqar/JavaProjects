package com.primetgi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// load the Java Spring Config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// load the bean
		Coach theCoach = context.getBean("badmintonCoach", Coach.class);

		// call the method from the bean

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\n------------------------");
		
		Coach theTTCoach = context.getBean("tableTennisCoach", Coach.class);
		
		System.out.println(theTTCoach.getDailyWorkout());
		System.out.println(theTTCoach.getDailyFortune());
		System.out.println("\n------------------------");
		
		

	}

}
