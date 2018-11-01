package com.primetgi.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("formValidator")
	private Validator validator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		webDataBinder.setValidator(validator);
	}

	@RequestMapping("/showForm")
	public String showForm(Map<String, Object> model) {

		System.out.println("Test 2 - Show Form");
		// Add the user Object
		User userForm = new User();

		// Add the user object to map
		model.put("userForm", userForm);
		initModelList(model);
		return "user-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("userForm") User user,
			BindingResult bindingResult, Map<String, Object> model) {
		// For Testing

		System.out.println("---------");
		System.out.println("User Name: " + user.getUserName());
		System.out.println("Password: " + user.getPassword());
		System.out.println("Email Id: " + user.getEmailId());
		System.out.println("Date Of Birth: " + user.getBirthDate());
		System.out.println("Profession: " + user.getProfession());
		System.out.println("---------");
		System.out.println("Binding Result: " + bindingResult);
		System.out.println("---------");

		if (bindingResult.hasErrors()) {
			initModelList(model);
			return "user-form";
		} else {
			return "user-confirmation";
		}

	}

	private void initModelList(Map<String, Object> model) {
		List<String> professionList = new ArrayList<>();
		professionList.add("Engineer");
		professionList.add("Govt Employee");
		professionList.add("Doctor");

		// Add professionList to model
		model.put("professionList", professionList);
	}

}
