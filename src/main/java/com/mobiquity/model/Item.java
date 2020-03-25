package com.mobiquity.model;

import javax.validation.constraints.Max;

public class Item {
	private final int index;
	
	@Max(100)
	private final double weight;
	
	@Max(100)
	private final double cost;

	public Item(int index, double weight, double cost) {
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	public int getIndex() {
		return index;
	}

	public double getWeight() {
		return weight;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + index;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (index != other.index)
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}
}
