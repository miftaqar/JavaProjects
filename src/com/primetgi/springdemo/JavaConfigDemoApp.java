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

	}

}
