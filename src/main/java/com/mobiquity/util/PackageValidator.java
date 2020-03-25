package com.mobiquity.util;

import java.util.List;
import java.util.Set;
import com.mobiquity.model.Package;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

public class PackageValidator {	
	
	public boolean isValid(List<Package> packages) {
		Validator validator = ValidationFactory.getValidator();
		ItemValidator itemValidator = new ItemValidator();
		for(Package pack : packages) {
			Set<ConstraintViolation<Package>> violations = validator.validate(pack);
			if(!violations.isEmpty() || !itemValidator.isValid(pack.getItems()))
				return false;
		}
		return true;
	}
}
