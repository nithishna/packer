package com.mobiquity.util;
import static com.mobiquity.util.Constants.INPUT_FILE;
import static com.mobiquity.util.Constants.INVALID_PACKAGE_WEIGHT;
import static com.mobiquity.util.Constants.INVALID_ITEM_COUNT;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.model.Package;
import com.mobiquity.packer.FileReader;

public class PackageValidatorTest {

	PackageValidator validator = new PackageValidator();
	
	@Test
	public void testIsValid_Success() throws IOException {
		List<Package> packs = FileReader.readFile(INPUT_FILE);
		boolean result = validator.isValid(packs);
		Assertions.assertEquals(true, result);
	}
	
	@Test
	public void testIsValid_InvalidPackageWeight() throws IOException {
		List<Package> packs = FileReader.readFile(INVALID_PACKAGE_WEIGHT);
		boolean result = validator.isValid(packs);
		Assertions.assertEquals(false, result);
	}
	
	@Test
	public void testIsValid_InvalidItemCount() throws IOException {
		List<Package> packs = FileReader.readFile(INVALID_ITEM_COUNT);
		boolean result = validator.isValid(packs);
		Assertions.assertEquals(false, result);
	}
}
