package com.primetgi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// load the Java Spring Config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class ,SportConfig.class);

		// load the bean
		Coach theCoach = context.getBean("badmintonCoach", Coach.class);

		// call the method from the bean

		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\n------------------------\n");

		Coach theTTCoach = context.getBean("tableTennisCoach", Coach.class);

		System.out.println(theTTCoach.getDailyWorkout());
		System.out.println(theTTCoach.getDailyFortune());
		System.out.println("\n------------------------\n");

		Coach theFbCoach = context.getBean("footBallCoach", Coach.class);

		System.out.println(theFbCoach.getDailyWorkout());
		System.out.println(theFbCoach.getDailyFortune());
		System.out.println("\n------------------------\n");
		
		CricketCoach theCricketCoach = context.getBean("cricketCoach", CricketCoach.class);

		System.out.println(theCricketCoach.getDailyWorkout());
		System.out.println(theCricketCoach.getDailyFortune());
		System.out.println("Team Name: "+theCricketCoach.getTeam());
		System.out.println("EmailId: "+theCricketCoach.getEmail());
		System.out.println("\n------------------------\n");

	}

}
