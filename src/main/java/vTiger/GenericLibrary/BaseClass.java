package vTiger.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTigerObjectRepository.HomePage;
import vTigerObjectRepository.LoginPage;

/**
 * This is a generic class which consists of all the basic configuration annotations
 * @author Rohit
 *
 */
public class BaseClass {
	
	public PropertyFileLibrary plib = new PropertyFileLibrary();
	public ExcelFileLibrary elib = new ExcelFileLibrary();
	public JavaLibrary jlib = new JavaLibrary();
	public WebDriverLibrary wlib = new WebDriverLibrary();
	
	public static WebDriver sdriver = null;
	
	public WebDriver driver = null;


	@BeforeSuite(groups = {"SmokeSuite","ReggressionSuite"})
	public void bsConfig()
	{
		System.out.println("Database connected successfully...");
	}
	
	@BeforeClass(groups = {"SmokeSuite","ReggressionSuite"})
	public void bcConfig() throws IOException
	{
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL = plib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser launched successfully "+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Browser launched successfully"+BROWSER);
		}
		else
		{
			System.out.println("Invalid browser entered");
		}
		
		sdriver = driver;
		wlib.maximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
	}
		
	@BeforeMethod(groups = {"SmokeSuite","ReggressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
			
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("login is successful...");
	}
		
	@AfterMethod(groups = {"SmokeSuite","ReggressionSuite"})
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.singOutOfApp(driver);
		System.out.println("SignOut is successful...");
	}
		
	@AfterClass(groups = {"SmokeSuite","ReggressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("browser is closed...");
	}
		
	@AfterSuite(groups = {"SmokeSuite","ReggressionSuite"})
	public void asConfig()
	{
		System.out.println("Database is closed...");
	}
}

