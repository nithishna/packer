package com.mobiquity.packer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.List;

import com.mobiquity.model.Package;

public class FileReader {

	public static List<Package> readFile(String path) throws IOException {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new java.io.FileReader(path));
			String line = reader.readLine();
			while(line != null) {
				if (!line.matches("\\d* :( \\(\\d*,\\d*(\\.\\d*)?,\\€\\d*\\))*")) {
					throw new InvalidObjectException("File format incorrect");				
				}					
				line = reader.readLine();
			}
		}finally {
			if(reader != null)
				reader.close();
		}
		return null;
	}
}