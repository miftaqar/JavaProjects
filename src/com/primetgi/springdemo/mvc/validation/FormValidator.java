package com.primetgi.springdemo.mvc.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.primetgi.springdemo.mvc.User;

public class FormValidator implements Validator {

	@Override
	public boolean supports(Class<?> params) {

		return User.class.equals(params);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// validating profession field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "profession", "valid.profession");

		// validating userName field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "valid.requiredField");

		// validating password field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.requiredField");

		// validating confirm password field
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "valid.passwordConf");

		User user = (User) obj;

		if (user.getPassword() == null || user.getConfirmPassword() == null) {
			user.setPassword("");
			user.setConfirmPassword("");
		}

		System.out.println("Password Field : " + user.getPassword());
		System.out.println("Confirm Password Field : " + user.getConfirmPassword());
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "valid.passwordConfDiff");
		}

	}

}
