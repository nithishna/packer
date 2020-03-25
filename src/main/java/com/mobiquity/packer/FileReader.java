package com.mobiquity.packer;

import static com.mobiquity.util.Constants.REGEX;
import static com.mobiquity.util.Constants.COLON;
import static com.mobiquity.util.Constants.FORMAT_ERROR_MESSAGE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.mobiquity.model.Item;
import com.mobiquity.model.Package;

public class FileReader {

	/**
	 * Reads the input file and converts it to a list of Items
	 * 
	 * Also validates the input file and encoding
	 * 
	 * */
	public static List<Package> readFile(String path) throws IOException {
		BufferedReader reader = null;
		List<Package> packages = new ArrayList<>();
		try {
			reader = new BufferedReader(new java.io.FileReader(path, StandardCharsets.UTF_8));
			String line = reader.readLine();
			while (line != null) {
				//File format validation using regular expression
				if (!line.matches(REGEX)) {
					throw new InvalidObjectException(FORMAT_ERROR_MESSAGE);
				}
				String[] values = line.split(COLON);
				//Extract the weight limit for the package
				double weight = Double.parseDouble(values[0]);
				Package pack = new Package(weight);
				//Extract the list of items given as input to select from
				String[] elements = values[1].split(" ");
				List<Item> items = new ArrayList<>();
				for (String element : elements) {
					element = element.substring(1, element.length() - 1);
					String[] itemDetails = element.split(",");
					Item item = new Item(Integer.parseInt(itemDetails[0]), Double.parseDouble(itemDetails[1]),
							Double.parseDouble(itemDetails[2].substring(1)));
					items.add(item);
				}
				//Add the extracted items to the package
				pack.setItems(items);
				packages.add(pack);
				line = reader.readLine();
			}
		} finally {
			if (reader != null)
				reader.close();
		}
		return packages;
	}
}