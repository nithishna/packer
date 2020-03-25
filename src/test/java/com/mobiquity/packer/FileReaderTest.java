package com.mobiquity.packer;
import static com.mobiquity.util.Constants.INPUT_FILE;
import static com.mobiquity.util.Constants.INVALID_FILE_ENCODING;
import static com.mobiquity.util.Constants.INVALID_FILE_FORMAT;
import static com.mobiquity.util.Constants.INVALID_FILE_PATH;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mobiquity.model.Package;

public class FileReaderTest {

	@Test
	public void readFile_NotFound() {
		Assertions.assertThrows(IOException.class, () -> FileReader.readFile(INVALID_FILE_PATH));
	}

	@Test
	public void readFile_InvalidFormat() {
		Assertions.assertThrows(IOException.class, () -> FileReader.readFile(INVALID_FILE_FORMAT));
	}

	@Test
	public void readFile_InvalidEncryption() {
		Assertions.assertThrows(IOException.class, () -> FileReader.readFile(INVALID_FILE_ENCODING));
	}
	
	@Test
	public void readFile_Success() throws IOException {
		List<Package> packs = FileReader.readFile(INPUT_FILE);
		
		Assertions.assertEquals(packs.size(), 4);
		Assertions.assertEquals(packs.get(0).getMaxWeight(), 81);
		Assertions.assertEquals(packs.get(0).getItems().get(0).getIndex(), 1);
		Assertions.assertEquals(packs.get(0).getItems().get(0).getCost(), 45);
		Assertions.assertEquals(packs.get(0).getItems().get(0).getWeight(), 53.38);
	}
}