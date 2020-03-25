package com.mobiquity.packer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mobiquity.model.Item;

public class ItemPicker {
	
	/**
	 * Picks the item in such a way that total cost is high and total weight is low
	 * */
	public static List<Item> pickItems(List<Item> items, double weight) {
		//Create another list and sort it based on cost.
		List<Item> weightItems = new ArrayList<>(items);
		Collections.sort(weightItems, (a, b) -> {
			return Double.compare(b.getCost(), a.getCost());
		});
		double maxCost = 0;
		double minWeight = 0;
		
		//This list holds the final output
		List<Item> finalPackageItems = new ArrayList<>();
		
		//Iterate through each item to find the highest possible cost
		for (Item item : items) {
			//This tempWeight variable is used to keep track of the weight calculation for each iteration
			double tempWeight = weight - item.getWeight();
			if (tempWeight < 0)
				continue;
			
			//tempPackageItems list holds the picked items for each iteration
			List<Item> tempPackageItems = new ArrayList<>();
			tempPackageItems.add(item);
			double cost = item.getCost();
			
			/*
			 * Iterate through the WeightItems to find the best possible selection
			 * Since the list is already in sorted order each match will be a better selection.
			 * 
			 * */
			for (Item i : weightItems) {
				if (tempWeight == 0)
					break;
				if (i == item)
					continue;
				if (i.getWeight() <= tempWeight) {
					cost += i.getCost();
					tempWeight -= i.getWeight();
					tempPackageItems.add(i);
				}
			}
			
			//If there are multiple list with same cost then pick the one with less weight
			if(maxCost == cost && minWeight > (weight-tempWeight)) {
				maxCost = cost;
				minWeight = weight - tempWeight;
				finalPackageItems = tempPackageItems;
			}
			else if(maxCost < cost){
				maxCost = cost;
				finalPackageItems = tempPackageItems;
				minWeight = weight - tempWeight;
			}	
		}
		return finalPackageItems;
	}
}