package com.automate.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
	private static Properties properties = new Properties();

	public static void loadFile(String source) {
		try {
			properties.load(new FileReader(new File(source)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Object get(String key,  Object defaultObj) {
		Object object = properties.get(key);
		return object != null? object : defaultObj;
	}

	public static Object get(String key) {
		return properties.get(key);
	}
	
	public static String getString(String key, String defaultVal){
		String val = properties.getProperty(key);
		return val!=null? val : defaultVal;
	}
	
	public static String getString(String key){
		return properties.getProperty(key);
	}

}
