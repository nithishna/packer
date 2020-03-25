package com.mobiquity.util;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidationFactory {
	private static Validator validator = null;
	private ValidationFactory() {}
	
	public static Validator getValidator() {		
		if(validator== null) {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			validator = factory.getValidator();
		}
		return validator;		
	}
}