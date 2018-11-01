package com.primetgi.springdemo.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/customer")
public class CustomerController {

	// add an initBinder...to convert trim input Strings
	// remove leading and trailing whitespace
	// resolve issue for our validation

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		binder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model model) {

		model.addAttribute("customer", new Customer());
		
		initModelList(model);

		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

		System.out.println("LastName: |" + customer.getLastName() + "|");
		
		System.out.println("Binding Result: "+bindingResult);
		
		System.out.println("\n\n\n\n");

		if (bindingResult.hasErrors()) {
			initModelList(model);
			return "customer-form";
		} else {
			return "customer-confirmation";
		}

	}
	
	public void initModelList(Model model) {
		List<String> countryList = new ArrayList<>();
		
		countryList.add("India");
		countryList.add("USA");
		countryList.add("UK");
		
		model.addAttribute("countryList", countryList);
	}
}
