package com.primetgi.springdemo;

public class LuckyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Luck is always with you";
	}

}
