package com.primetgi.springdemo;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	// create a random number generator
	private Random random = new Random();

	@Override
	public String getFortune() {

		String fortune = "";

		ArrayList<String> getFortunesList = readFortunesFromFile();

		int index = random.nextInt(getFortunesList.size());
		fortune = getFortunesList.get(index);

		return fortune;
	}

	private ArrayList<String> readFortunesFromFile() {
		ArrayList<String> fortunesList = null;
		String token = "";
		try {
			// create Scanner inputFile
			Scanner inputFile = new Scanner(new File("src/Fortunes.txt")).useDelimiter(",\\s*");
			fortunesList = new ArrayList<String>();

			while (inputFile.hasNext()) {
				token = inputFile.next();
				fortunesList.add(token);
			}
			inputFile.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return fortunesList;

	}

}
