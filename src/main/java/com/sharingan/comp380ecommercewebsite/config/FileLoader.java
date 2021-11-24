package com.sharingan.comp380ecommercewebsite.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles loading a file and reading its contents
 *
 * @version 1.0.1
 * @since 2021-19-11
 */
public class FileLoader {

	/**
	 * This method reads a file line by line and loads it into a list
	 * @param file Provides the file to read from
	 * @return Returns a string array of the file contents
	 */
	public static List<String> readFileToArray(File file) {

		// Write config file to ArrayList
		List<String> configArray = new ArrayList<>();

		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null)
				configArray.add(line);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configArray;
	}

}