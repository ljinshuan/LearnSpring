package com.tmall.wireless.spring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
		Person person=(Person)target;
		if (person.getAge()<0) {
			errors.rejectValue("age", "negativevalue","年龄不能为负");
		}else if(person.getAge()>110){
			errors.rejectValue("age", "too.darn.old","年龄太大");
		}
	}

}
