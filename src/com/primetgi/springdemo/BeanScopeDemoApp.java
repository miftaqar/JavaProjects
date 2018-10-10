package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");

		// retrieve bean from the config file
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if they are same
		boolean result = (theCoach == alphaCoach);

		// Print the results
		System.out.println("\nPointing to the same object: " + result);

		System.out.println("\nMemory Location for theCoach: " + theCoach);

		System.out.println("\nMemory Location for alphaCoach: " + alphaCoach);

		System.out.println("From- theCoach: "+theCoach.getDailyFortune());
		System.out.println("From- alphaCoach: "+alphaCoach.getDailyFortune());
		// close the context

		context.close();
	}

}
