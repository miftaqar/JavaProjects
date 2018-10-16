package com.primetgi.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsBeanDemoApp {

	public static void main(String[] args) {
		// load the Spring Config File
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retreive bean from the Spring File
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//check if they are same
		boolean result = (theCoach == alphaCoach);
		
		//check if both are same
		System.out.println("\n Pointing to Same Location: "+result);
		
		System.out.println("\n Memory Location for theCoach: "+theCoach);
		
		System.out.println("\n Memory Location for alphaCoach: "+alphaCoach);
		
		//close the context
		context.close();
		
		
		

	}

}
