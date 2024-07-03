package com.SwagLabs.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	public Properties p1;

	public PropertiesUtil() {
		// Properties file
		p1 = new Properties();

		// File
		File f1 = new File("./" + "config.properties");

		// read in a stream
		FileInputStream fs;
		try {
			fs = new FileInputStream(f1);
			p1.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getData(String key) 
	{
		return p1.getProperty(key);
	}

}