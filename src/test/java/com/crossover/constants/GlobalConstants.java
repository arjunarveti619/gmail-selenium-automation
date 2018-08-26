package com.crossover.constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class GlobalConstants {

	public static Properties prop = new Properties();
	public static final String BROWSER_NAME = get("default.browser");
	public static final String USERNAME = get("username");
	public static final String PASSWORD = get("password");
	public static final String SUBJECT = get("subject");
	public static final String BODY = get("body");
	public static final String FILE_PATH = get("filename");
	public static final String FILE_NAME = (FILE_PATH.substring(FILE_PATH.lastIndexOf('\\')+1,FILE_PATH.lastIndexOf('.')))+(FILE_PATH.substring(FILE_PATH.lastIndexOf('.')));
	public static final String DRIVER_IMPLICIT_WAIT_TIME_DEFAULT = get("implicit_wait_time");
	public static final String SERVER_URL = get("url");
	public static final String CHROME_DRIVER_PATH = get("chrome_driver_path");
	public static final String FIREFOX_DRIVER_PATH = get("firefox_driver_path");
	public static final String IE_DRIVER_PATH = get("ie_driver_path");

	public static String get(String key) {

		loadProperties();
		return prop.getProperty(key);
	}

	private static void loadProperties() {
		try {
			FileInputStream fis = new FileInputStream("test.properties");

			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
