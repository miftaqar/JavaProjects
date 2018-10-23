package com.primetgi.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML Form

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	// need a controller method to process the HTML form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	// new controller to read a read HTML Form Data
	// add data to Model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		//read the input from the Html form
		String theName = request.getParameter("studentName");
		
		//convert the request data into caps 
		theName = theName.toUpperCase();
		
		//create the message
		String result= "Yo! " +theName;
		
		//add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
