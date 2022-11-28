package com.seasonalloan.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Dorothy.Kisormoi
 *
 */
public class ConfigFileReader {

	static Properties prop;

	public static void ReadConfig() {
//Create object of class properties class
		prop = new Properties();
		File src = new File("./Configuration/Config.properties");
//Create object of class inputStream
		try {
			FileInputStream input = new FileInputStream(src);
// Load properties file
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());
		}
// Get values from properties file
	}

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseUrl");
		return url;
	}

}