package vTigerContactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateContactsTest {
	
	@Test(groups = "SmokeSuite")
	public void CreateContactsTest() throws IOException
	{
	
	JavaLibrary jLib = new JavaLibrary();
	ExcelFileLibrary eLib = new ExcelFileLibrary();
	PropertyFileLibrary pLib = new PropertyFileLibrary();
	WebDriverLibrary wLib = new WebDriverLibrary();
	
	//read data from property file
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	String MAC= pLib.readDataFromPropertyFile("mac");
	
	//Step3: launch the browser
	WebDriver driver = null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		System.out.println("browser is launched..."+BROWSER);
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println("browser is launched..."+BROWSER);
	}
	else
		System.out.println("Invalid browser name is entered...");
	
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	
	//Step4: Enter the credentials 
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//Step5: create a contact
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	//enter the mandatory fields and save
	driver.findElement(By.name("lastname")).sendKeys(MAC);;
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Step6: sign-outs
	WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseHoverOn(driver, signout);
	driver.findElement(By.linkText("Sign Out")).click();
	
	}
}
