package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve the bean from configuration file
		Coach theCoach = context.getBean("myCoach", Coach.class);

		// call methods on bean
		System.out.println("From Spring App");
		System.out.println(theCoach.getDailyWorkout());

		// close the context
		context.close();
	}

}
