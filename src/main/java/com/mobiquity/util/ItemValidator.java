package com.mobiquity.util;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import com.mobiquity.model.Item;

public class ItemValidator {

	public boolean isValid(List<Item> items) {
		Validator validator = ValidationFactory.getValidator();
		for(Item item : items) {
			Set<ConstraintViolation<Item>> violations = validator.validate(item);
			if(!violations.isEmpty())
				return false;
		}
		return true;
	}
}
