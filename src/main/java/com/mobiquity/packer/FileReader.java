package com.mobiquity.packer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.mobiquity.model.Item;
import com.mobiquity.model.Package;

public class FileReader {

	public static List<Package> readFile(String path) throws IOException {
		BufferedReader reader = null;
		List<Package> packages = new ArrayList<>();
		try {
			reader = new BufferedReader(new java.io.FileReader(path, StandardCharsets.UTF_8));
			String line = reader.readLine();
			while (line != null) {
				if (!line.matches("\\d* :( \\(\\d*,\\d*(\\.\\d*)?,\\€\\d*\\))*")) {
					throw new InvalidObjectException("File format incorrect");
				}
				String[] values = line.split(" : ");
				double weight = Double.parseDouble(values[0]);
				Package pack = new Package(weight);
				String[] elements = values[1].split(" ");
				List<Item> items = new ArrayList<>();
				for (String element : elements) {
					element = element.substring(1, element.length() - 1);
					String[] itemDetails = element.split(",");
					Item item = new Item(Integer.parseInt(itemDetails[0]), Double.parseDouble(itemDetails[1]),
							Double.parseDouble(itemDetails[2].substring(1)));
					items.add(item);
				}
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