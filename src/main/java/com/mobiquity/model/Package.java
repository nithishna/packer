package com.mobiquity.model;

import java.util.ArrayList;
import java.util.List;

public final class Package {
	private final double maxWeight;
	private List<Item> items = new ArrayList<>();
	
	public Package(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public double getMaxWeight() {
		return maxWeight;
	}
}