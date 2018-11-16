package com.primetgi.springdemo.mvc;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Value("#{${subjectOptions}}")
	private Map<String, String> subjectOptions;

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	// method to display the form

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		System.out.println("In showForm Method");
		// create a Student Object
		Student student = new Student();

		// Add Student Object to the model
		model.addAttribute("student", student);

		// Add country Options to the model
		model.addAttribute("theSubjectOptions", subjectOptions);

		return "student-form";
	}

	// method to process the form data

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
		System.out.println("In processForm Method");

		// log the input data
		System.out.println("The Student: " + student.getFirstName() + " " + student.getLastName());
		if(bindingResult.hasErrors()) {
			return "student-form";
		} else {
			return "student-confirmation";
		}
		
	}
}
