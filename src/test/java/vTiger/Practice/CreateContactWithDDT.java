package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;


@Listeners(vTiger.GenericLibrary.ListnerImplementationClass.class)
public class CreateContactWithDDT {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj= new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("==="+BROWSER+ "is launched===");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new FirefoxDriver();
			System.out.println("==="+BROWSER+ "is launched===");
		}
		else
		{
			System.out.println("entered browser is invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		//step3: login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//step4: navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//step5: create contact with mandatory fields
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("rohit");
		
		//step6: save
		driver.findElement(By.className("crmButton small save")).click();
		
		//step7: logout
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
