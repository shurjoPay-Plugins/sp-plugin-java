package com.shurjopay.plugin;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Al - Amin
 * @since 2022-06-13
 */
public class PropertiesReader {
	Logger logger = Logger.getLogger(PropertiesReader.class.getName());
	
	private static PropertiesReader instance = null;
	Properties prop = new Properties();
	
	private PropertiesReader() {
		
	}

	public Properties getProperties() {
		
		try {
			prop.load(PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties"));
			return prop;
		} catch (IOException e) {
			logger.log(Level.FINE, "config.properties is missing in resource path");
			return null;
		}
	}
	
	public static PropertiesReader instance()
    {
        if (instance == null)
            instance = new PropertiesReader();
  
        return instance;
    }
}
