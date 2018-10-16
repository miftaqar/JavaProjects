package com.primetgi.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// create an array of Strings
	private String[] data = { "Time is precious", "Smart Work is better than HardWork", "The Journey is the reward" };

	// create a random number generator
	private Random random = new Random();

	@Override
	public String getFortune() {
		// pick a random array of Strings
		int index = random.nextInt(data.length);

		String fortune = data[index];
		return fortune;
	}

}
