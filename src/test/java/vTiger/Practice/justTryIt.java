package vTiger.Practice;

import java.io.IOException;

import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class justTryIt {

	public static void main(String[] args) throws IOException {


		// Step 1: Create Object of all the libraries
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();

				// Step 2: read all the required data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String URL = pLib.readDataFromPropertyFile("url");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");

				String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2) + jLib.getRandomNumber();
				System.out.println(LASTNAME);
				String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
				System.out.println(ORGNAME);

	}

}
