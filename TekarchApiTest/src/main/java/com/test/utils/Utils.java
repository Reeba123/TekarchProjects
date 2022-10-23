package com.test.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.test.constants.Sourcepath;


public class Utils {
	
	public String getconfigproperty(String key){
		Properties propertyfile=new Properties();
		String filepath=Sourcepath.CONFIG_PROPERTY_PATH;
		
		FileReader file = null;
		try {
			file = new FileReader(filepath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			propertyfile.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			String value=propertyfile.getProperty(key);
			System.out.println("Property from the file:"+value);
			return value;
		}
		
		}


