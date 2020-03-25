package com.mobiquity.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public final class Package {
	
	@Max(100)
	private final double maxWeight;
	
	@Size(max=15)
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