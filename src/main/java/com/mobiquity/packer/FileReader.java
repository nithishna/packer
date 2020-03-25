package com.mobiquity.packer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileReader {

	public static List<Package> readFile(String path) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new java.io.FileReader(path));
		}finally {
			if(reader != null)
				reader.close();
		}
		return null;
	}
}