package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateLeadWithProduct {

	public static void main(String[] args) throws IOException {
		
		
		//Step1: Create object of all the libraries
				JavaLibrary jLib = new JavaLibrary();
				PropertyFileLibrary pLib = new PropertyFileLibrary();
				WebDriverLibrary wLib = new WebDriverLibrary();
				ExcelFileLibrary eLib = new ExcelFileLibrary();
				
				//Step2: Read the necessary data
				String BROWSER = pLib.readDataFromPropertyFile("browser");
				String USERNAME = pLib.readDataFromPropertyFile("username");
				String PASSWORD = pLib.readDataFromPropertyFile("password");
				String URL = pLib.readDataFromPropertyFile("url");

				String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jLib.getRandomNumber();
				String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber();
				
				//Step3: Launch the browser
				WebDriver driver = null;
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("browser is launched..."+BROWSER);
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					System.out.println("Browser is launched..."+BROWSER);
				}
				else
					System.out.println("Invalid browser is entered...");
				
				wLib.maximizeWindow(driver);
				wLib.waitForPageLoad(driver);
				driver.get(URL);
				
				//Step4: Login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step5: create lead 
				driver.findElement(By.linkText("Leads")).click();
				
				//Step6: click on look up image to create a lead
				driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
				
				//Step7: Fill the mandatory data 
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				driver.findElement(By.name("company")).sendKeys(ORGNAME);
				
				//Step8: Save the lead
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
