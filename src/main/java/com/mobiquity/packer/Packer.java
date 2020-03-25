package com.mobiquity.packer;

import static com.mobiquity.util.Constants.COMMA;
import static com.mobiquity.util.Constants.EMPTY_STRING;
import static com.mobiquity.util.Constants.HYPHEN;
import static com.mobiquity.util.Constants.NEW_LINE;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.mobiquity.exception.APIException;
import com.mobiquity.model.Item;
import com.mobiquity.model.Package;
import com.mobiquity.util.PackageValidator;

public class Packer {

	public static String pack(String path) throws APIException {
		List<Package> packs = null;
		try {
			packs = FileReader.readFile(path);
			if (packs.isEmpty())
				return EMPTY_STRING;
			PackageValidator validator = new PackageValidator();
			if(!validator.isValid(packs))
				throw new APIException("Data validation failed");
			for (Package pack : packs) {
				List<Item> items = ItemPicker.pickItems(pack.getItems(), pack.getMaxWeight());
				pack.setItems(items);
			}

		} catch (IOException ex) {
			throw new APIException(ex.getMessage(), ex);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < packs.size(); i++) {
			if (packs.get(i).getItems().isEmpty())
				builder.append(HYPHEN);
			builder.append(
					packs.get(i).getItems().stream().map(c -> c.getIndex() + EMPTY_STRING).collect(Collectors.joining(COMMA)));
			if (i < packs.size() - 1)
				builder.append(NEW_LINE);
		}
		return builder.toString();
	}

}
