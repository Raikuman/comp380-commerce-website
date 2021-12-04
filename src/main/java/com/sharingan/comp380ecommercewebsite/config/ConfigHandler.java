package com.sharingan.comp380ecommercewebsite.config;

import java.io.File;

/**
 * This class handles loading and editing config files and settings
 *
 * @version 1.0.1
 * @since 2021-09-11
 */
public class ConfigHandler {

	/**
	 * This method gets a config setting from the given file and string by searching the file
	 * @param config The config setting to search for
	 * @return Returns the setting of the config
	 */
	public static String loadConfigSetting(String config) {

		File file = new File("config.txt");

		// Check if file exists
		if (!file.exists()) {
			return null;
		}

		// Get config from file
		String readConfig = null;
		for (String arrayString : FileLoader.readFileToArray(file))
			if (arrayString.contains(config)) {
				readConfig = arrayString;
				break;
			}

		if (readConfig != null) {

			// Get setting of the config
			return readConfig.split("=")[1];
		}
		else {
			return null;
		}
	}
}
