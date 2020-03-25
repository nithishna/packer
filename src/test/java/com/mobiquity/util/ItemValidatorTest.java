package com.mobiquity.util;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.model.Item;

public class ItemValidatorTest {

	ItemValidator validator = new ItemValidator();
	
	@Test
	public void testIsValid_Success() {
		List<Item> items = Arrays.asList(new Item(1,35,100), new Item(2,100, 99));
		boolean result = validator.isValid(items);
		Assertions.assertEquals(true, result);
	}
	
	@Test
	public void testIsValid_WeightFailure() {
		List<Item> items = Arrays.asList(new Item(1,35,20), new Item(2,101.5, 99));
		boolean result = validator.isValid(items);
		Assertions.assertEquals(false, result);
	}
	
	@Test
	public void testIsValid_CostFailure() {
		List<Item> items = Arrays.asList(new Item(1,35,20), new Item(2,91.5, 101));
		boolean result = validator.isValid(items);
		Assertions.assertEquals(false, result);
	}	
}