package com.primetgi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SquashJavaConfigDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class,
				SportConfig.class);

		SquashCoach theCoach = context.getBean("squashCoach", SquashCoach.class); // uses Default BeanId

		// call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		//call getEmail and getTeam methods... is the props value injected
		System.out.println("EmailId: " + theCoach.getEmail());
		System.out.println("Team Name: " + theCoach.getTeam());
		System.out.println("\n------------------------------");

		// close the context
		context.close();
	}

}
