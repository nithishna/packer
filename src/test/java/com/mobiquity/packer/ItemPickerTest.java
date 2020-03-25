package com.mobiquity.packer;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.model.Item;

public class ItemPickerTest {
	@Test
	public void testPickItems_NormalSuccessScenario() {
		List<Item> items = Arrays.asList(new Item(1,85.31,29),new Item(2,14.55,74),new Item(3,3.98,16),new Item(4,26.24,55),new Item(5,63.69,52), new Item(6,76.25,75),new Item(7,60.02,74),new Item(8,93.18,35),new Item(9,89.95,78));
		List<Item> result = ItemPicker.pickItems(items, 75);
		Assertions.assertEquals(result.get(0), items.get(1));
		Assertions.assertEquals(result.get(1), items.get(6));
	}
	
	@Test
	public void testPickItems_LessWeightMoreCost() {
		List<Item> items = Arrays.asList(new Item(1,53.38,45),new Item(2,88.62,98),new Item(3,78.48,3),new Item(4,72.30,76),new Item(5,30.18,9),new Item(6,46.34,48));
		List<Item> result = ItemPicker.pickItems(items, 81);
		Assertions.assertEquals(result.get(0), items.get(3));
	}

	@Test
	public void testPickItems_NoItemForSelection() {
		List<Item> items = Arrays.asList(new Item(1,15.3,34));
		List<Item> result = ItemPicker.pickItems(items, 8);
		Assertions.assertTrue(result.isEmpty());
	}

	@Test
	public void testPickItems_TwoItemsWithSameCost() {
		List<Item> items = Arrays.asList(new Item(1,90.72,13),new Item(2,33.80,40),new Item(3,43.15,10),new Item(4,37.97,16),new Item(5,46.81,36),new Item(6,48.77,79),new Item(7,81.80,45),new Item(8,19.36,79),new Item(9,6.76,64));
		List<Item> expectedResult = Arrays.asList(new Item(8,19.36,79),new Item(9,6.76,64));
		List<Item> result = ItemPicker.pickItems(items, 56);
		int counter = 0;
		for(Item item : result) {
			Assertions.assertEquals(item, expectedResult.get(counter++));
		}
	}
}
