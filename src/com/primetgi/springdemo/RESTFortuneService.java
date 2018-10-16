package com.primetgi.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "Enoy your REST Life";
	}

}
