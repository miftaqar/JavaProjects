package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {
		// read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from the spring container 
		//Coach theCoach = context.getBean("theTennisCoach", Coach.class);		//uses Explicit BeanId
		Coach theCoach = context.getBean("tennisCoach", Coach.class);		//uses Default BeanId	
		
		//call the methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		Coach theBoxingCoach = context.getBean("boxingCoach", Coach.class);
		System.out.println("From Boxing Coach: "+theBoxingCoach.getDailyWorkout());
		System.out.println("From Boxing Coach: "+theBoxingCoach.getDailyFortune());
		
		
		//close the context
		context.close();
	}

}
