package com.mobiquity.packer;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FileReaderTest {

	@Test
	public void readFile_NotFound() {
		String filePath = "invalidFilePath";
		Assertions.assertThrows(IOException.class, ()->FileReader.readFile(filePath));
	}
}
