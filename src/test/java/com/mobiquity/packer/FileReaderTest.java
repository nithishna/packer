package com.mobiquity.packer;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTest {

	@Test
	public void readFile_NotFound() {
		String filePath = "invalidFilePath";
		Assertions.assertThrows(IOException.class, ()->FileReader.readFile(filePath));
	}
	
	@Test
	public void readFile_InvalidFormat() {
		File file = new File("src/test/resources/example_input_invalid_format");
		String path = file.getAbsolutePath();
		Assertions.assertThrows(IOException.class, ()->FileReader.readFile(path));
	}
	
}
