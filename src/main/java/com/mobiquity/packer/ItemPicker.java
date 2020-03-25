package com.mobiquity.packer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquity.model.Item;

public class ItemPicker {
	public static List<Item> pickItems(List<Item> items, double weight) {
		List<Item> weightItems = new ArrayList<>(items);
		Collections.sort(weightItems, (a, b) -> {
			return Double.compare(b.getCost(), a.getCost());
		});
		double maxCost = 0;
		List<Item> finalPackageItems = new ArrayList<>();
		for (Item item : items) {
			double tempWeight = weight - item.getWeight();
			if (tempWeight < 0)
				continue;
			List<Item> index = new ArrayList<>();
			index.add(item);
			double cost = item.getCost();
			for (Item i : weightItems) {
				if (tempWeight == 0)
					break;
				if (i == item)
					continue;
				if (i.getWeight() <= tempWeight) {
					cost += i.getCost();
					tempWeight -= i.getWeight();
					index.add(i);
				}
			}
			if (maxCost < cost) {
				maxCost = cost;
				finalPackageItems = index;
			}
		}

		return finalPackageItems;
	}
}
