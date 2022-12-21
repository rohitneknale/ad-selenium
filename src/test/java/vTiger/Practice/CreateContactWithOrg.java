package vTiger.Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateContactWithOrg {

	public static void main(String[] args) throws IOException {
		
		//Step1: Create object of all the libraries
		JavaLibrary jLib = new JavaLibrary();
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		
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
		
		//Step5: Create a new organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//Step6: validate for organization created
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(orgHeader);
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println("Organization is created");
		}
		else
		{
			System.out.println("Organization creation failed");
			wLib.takeScreenShot(driver, "CreateContactWithOrg");
		}
		
		//Step7: create a new contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Step8: Select the org created on org window
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
		wLib.switchTowindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(ORGNAME)).click();
		//driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']"));
		wLib.switchTowindow(driver, "Contacts");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step9: validate for contact with organization is created
		String ContactsHead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(ContactsHead);
		if(ContactsHead.contains(LASTNAME))
		{
			System.out.println("Contact with organization is created");
		}
		else
		{
			System.out.println("Contact with organization creation is failed");
		}
		
		//Step10: Logout from the application 
		WebElement sOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHoverOn(driver, sOut);
		driver.findElement(By.linkText("Sign Out")).click();
		
		
		driver.close();
	}

}
