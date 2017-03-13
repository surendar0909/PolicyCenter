package com.eplan.register;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return UserModel.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors error) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(error, "username", "user.username", "Username cannot be empty");
		
	}

}
