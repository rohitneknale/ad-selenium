package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateOrganization  {

	
	public static void main(String[] args) throws IOException
	{
		
		//step1: read the required data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		Properties pobj = new Properties();
		pobj.load(fis);
		WebDriverLibrary wlib = new WebDriverLibrary();
		JavaLibrary jlib= new JavaLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String ORGNAME = eLib.readDataFromExcel("Contacts", 4, 3)+jlib.getRandomNumber();
		String LASTNAME = eLib.readDataFromExcel("Contacts", 4, 2)+jlib.getRandomNumber();
		
		//step2:launch the browser
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("browser is launched..."+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("Browser is launched..."+BROWSER);
		}
		else
			System.out.println("Invalid browser is launched");
		
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOn(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
}
