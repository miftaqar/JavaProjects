package com.primetgi.springdemo;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	// create a random number generator
	private Random random = new Random();
	private ArrayList<String> fortunesList;

	@Override
	public String getFortune() {

		String fortune = "";

		// If fortunesList is retreived from below method
		// ArrayList<String> getFortunesList = readFortunesFromFile();

		int index = random.nextInt(fortunesList.size());
		fortune = fortunesList.get(index);

		return fortune;
	}

	private ArrayList<String> readFortunesFromFile() {

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

	// define PostConstruct Method
	@PostConstruct
	public void readFortunesAtStart() {
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

			// String[] temmpArray = fortunesList.toArray(new String[0]);
			//
			// System.out.println(">> From Post Construct Method - FileFortuneService >>");
			// for(String s : temmpArray) {
			// System.out.println("\n "+s);
			// }
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}
