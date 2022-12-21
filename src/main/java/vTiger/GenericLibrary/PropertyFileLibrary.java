package vTiger.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * This class contains generic methods related to property files
 * @author Admin
 *
 */
public class PropertyFileLibrary {
	
	
	/**
	 * This method will read the value from property file for the key given by the user
	 * @param Key
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream(IConstantsLibrary.propertyFilePath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(Key);
		return value;
	}
}
