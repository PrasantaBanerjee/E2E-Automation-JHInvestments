package org.jhi.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	public final String configFilePath = System.getProperty("user.dir") + "\\src\\org\\jhi\\resources\\properties\\config.properties";
	public Properties configFile;

	public PropertyFileReader() {
		try (FileInputStream fis = new FileInputStream(configFilePath)){
			configFile = new Properties();
			configFile.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 		
	}
	
	public String getProperty(String key) {
		if(key==null || key.isEmpty()) {
			return "";
		}
		return configFile.getProperty(key);
	}
}