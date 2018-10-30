package com.primetgi.springdemo.mvc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.primetgi.springdemo.mvc.User;

public class ProfessionValidator implements Validator{

	@Override
	public boolean supports(Class<?> params) {
		
		return User.class.equals(params);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "profession", "valid.profession");
		
	}

}
