package com.mobiquity.packer;

import static com.mobiquity.util.Constants.EMPTY_FILE;
import static com.mobiquity.util.Constants.INVALID_FILE_FORMAT;
import static com.mobiquity.util.Constants.INPUT_FILE;
import static com.mobiquity.util.Constants.OUTPUT_FILE;
import static com.mobiquity.util.Constants.INVALID_ITEM_COUNT;
import static com.mobiquity.util.Constants.INVALID_PACKAGE_WEIGHT;
import static com.mobiquity.util.Constants.INVALID_ITEM_COST;
import static com.mobiquity.util.Constants.INVALID_ITEM_WEIGHT;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.exception.APIException;

public class PackerTest {

	@Test
	public void testPacker_EmptyFile() throws APIException {
		File file = new File(EMPTY_FILE);
		String absolutePath = file.getAbsolutePath();
		String result = Packer.pack(absolutePath);
		String emptyString = "";
		Assertions.assertEquals(result, emptyString);
	}

	@Test
	public void testPacker_InvalidFileFormat() {
		File file = new File(INVALID_FILE_FORMAT);
		String absolutePath = file.getAbsolutePath();
		Assertions.assertThrows(APIException.class, () -> Packer.pack(absolutePath));
	}

	@Test
	public void testPacker_Success() throws IOException, APIException {
		File file = new File(INPUT_FILE);
		String absolutePath = file.getAbsolutePath();
		String result = Packer.pack(absolutePath);
		String expectedOutput = new String(Files.readAllBytes(Paths.get(new File(OUTPUT_FILE).getAbsolutePath())));
		Assertions.assertEquals(expectedOutput, result);
	}

	@Test
	public void testPackage_InvalidPackageWeight() {
		File file = new File(INVALID_PACKAGE_WEIGHT);
		String absolutePath = file.getAbsolutePath();
		Assertions.assertThrows(APIException.class, () -> Packer.pack(absolutePath));
	}

	@Test
	public void testPackage_InvalidItemCount() {
		File file = new File(INVALID_ITEM_COUNT);
		String absolutePath = file.getAbsolutePath();
		Assertions.assertThrows(APIException.class, () -> Packer.pack(absolutePath));
	}

	@Test
	public void testPackage_InvalidItemWeight() {
		File file = new File(INVALID_ITEM_WEIGHT);
		String absolutePath = file.getAbsolutePath();
		Assertions.assertThrows(APIException.class, () -> Packer.pack(absolutePath));
	}
	
	@Test
	public  void testPackage_InvalidItemCost() {
		File file = new File(INVALID_ITEM_COST);
		String absolutePath = file.getAbsolutePath();
		Assertions.assertThrows(APIException.class, () -> Packer.pack(absolutePath));
	}
}