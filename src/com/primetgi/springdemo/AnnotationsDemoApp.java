package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {
		// read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from the spring container
		// Coach theCoach = context.getBean("theTennisCoach", Coach.class); //uses
		// Explicit BeanId
		Coach theCoach = context.getBean("tennisCoach", Coach.class); // uses Default BeanId

		// call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\n------------------------------");

		Coach theBoxingCoach = context.getBean("boxingCoach", Coach.class);
		System.out.println("From Boxing Coach: " + theBoxingCoach.getDailyWorkout());
		System.out.println("From Boxing Coach: " + theBoxingCoach.getDailyFortune());
		System.out.println("\n------------------------------");

		Coach theCricketCoach = context.getBean("cricketCoach", Coach.class);
		System.out.println("From Cricket Coach: " + theCricketCoach.getDailyWorkout());
		System.out.println("From Cricket Coach: " + theCricketCoach.getDailyFortune());
		System.out.println("\n------------------------------");

		Coach theSwimCoach = context.getBean("swimCoach", Coach.class);
		System.out.println("From Swim Coach: " + theSwimCoach.getDailyWorkout());
		System.out.println("From Swim Coach: " + theSwimCoach.getDailyFortune());
		System.out.println("\n------------------------------");

		Coach theSoccerCoach = context.getBean("soccerCoach", Coach.class);
		System.out.println("From Soccer Coach: " + theSoccerCoach.getDailyWorkout());
		System.out.println("From Soccer Coach: " + theSoccerCoach.getDailyFortune());
		// close the context
		context.close();
	}

}
