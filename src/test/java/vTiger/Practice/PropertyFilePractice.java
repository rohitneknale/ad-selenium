package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Load the file into java stream
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//create object to properties
		Properties p=new Properties();
		
		//load the file into stream into properties
		p.load(f);
		
		//use the keys to read the value
		String BROWSER = p.getProperty("Browser");
		System.out.println(BROWSER);
		
		String URL = p.getProperty("url");
		
		
	}
	

}
