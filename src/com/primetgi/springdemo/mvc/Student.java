package com.primetgi.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String subject;
	private String favoriteLanguage;
	private String age;

	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> ageOptions;

	public Student() {

		// populate Country options
		System.out.println("In Student Constructor");

		countryOptions = new LinkedHashMap<>();
		countryOptions.put("FR", "France");
		countryOptions.put("US", "United Stated of America");
		countryOptions.put("IN", "India");
		countryOptions.put("UK", "London");
		
		ageOptions = new LinkedHashMap<>();
		ageOptions.put("15-20", "15-20");
		ageOptions.put("21-25", "21-25");
		ageOptions.put("26-30", "26-30");

	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public LinkedHashMap<String, String> getAgeOptions() {
		return ageOptions;
	}

	
}
