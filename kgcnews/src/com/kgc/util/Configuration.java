package com.kgc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
	private Configuration() {
		pp = new Properties();
		InputStream is = Configuration.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			pp.load(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Configuration config;
	private Properties pp;
	
	public static Configuration getConfig() {
		if(config == null) {
			config = new Configuration();
		}
		return config;
	}
	
	public String getkey(String key) {
		return pp.getProperty(key);
	}
}
