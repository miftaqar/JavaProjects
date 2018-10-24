package com.primetgi.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	// method to display the form

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		
		// create a Student Object
		Student student = new Student();
		
		//Add Student Object to the model
		model.addAttribute("student", student);
		return "student-form";
	}
}
