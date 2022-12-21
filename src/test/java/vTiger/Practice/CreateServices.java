package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateServices {

	@Test(groups = "SmokeSuite")
	
	public void createServiesTest() throws IOException {
		
		
		//Step1: Read the required data
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj = new Properties();
		WebDriverLibrary wlib = new WebDriverLibrary();
		JavaLibrary jlib= new JavaLibrary();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
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
		
		//Step3: Login to application 
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		wlib.mouseHoverOn(driver, element);
		driver.findElement(By.name("Services")).click();
		
		//Step4: Create a new Service and save
		driver.findElement(By.xpath("//img[@title='Create Service...']")).click();
		driver.findElement(By.name("servicename")).sendKeys("Foodi");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step5:Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseHoverOn(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
