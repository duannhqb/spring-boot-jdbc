package edu.poly.spring.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.poly.spring.model.Student;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.requied.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "field.requied.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.requied.phone");
	}

}
