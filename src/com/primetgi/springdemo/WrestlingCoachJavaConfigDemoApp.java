package com.primetgi.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WrestlingCoachJavaConfigDemoApp {

	public static void main(String[] args) {
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class,
				SportConfig.class);

		Coach theCoach = context.getBean("wrestlingCoach", Coach.class); // uses Default BeanId

		// call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		System.out.println("\n------------------------------");

		// close the context
		context.close();
	}

}
