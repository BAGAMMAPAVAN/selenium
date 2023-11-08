package GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtility {
	private Properties property;
	
	/**
	 * This method is used to intialize properties file
	 * @param filepath
	 */
	public void propertiesInitialization(String filepath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to fetch data from properties file
	 * @param key
	 * @return
	 */
	public String readfromproperties(String key) {
		return property.getProperty(key);
	}

}
