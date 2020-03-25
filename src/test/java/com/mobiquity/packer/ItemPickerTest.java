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

}
