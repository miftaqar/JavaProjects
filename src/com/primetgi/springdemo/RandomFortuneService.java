package com.primetgi.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// create an array of Strings
	private String[] data = { "Today is your lucky day", "The Journey is your reward",
			"Try and try until you acheive success" };
	
	//create a random number generator
	private Random myRandom = new Random();

	@Override
	public String getFortuneService() {

		//pick a random String from an array 
		int index = myRandom.nextInt(data.length);
		
		String fortuneElement = data[index];

		return fortuneElement;
	}

}
