package vTigerObjectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateOrgnizationPage {
	
	private static final String LASTNAME = null;

	public static void main(String[] args) throws IOException {
		
		//Step1: Create all object
		PropertyFileLibrary pLib = new PropertyFileLibrary();
		JavaLibrary jLib = new JavaLibrary();
		ExcelFileLibrary eLib = new ExcelFileLibrary();
		WebDriverLibrary wLib = new WebDriverLibrary();
		WebDriver driver= null;
		
		//Step2: Read the data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		String URL = pLib.readDataFromPropertyFile("url");
		
		String ORGNAME = eLib.readDataFromExcel("Orgnizations", 1, 2);
		
		//Step3:Launch the browser- run time polymorphism- driver
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			System.out.println("Browser is launched.."+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			System.out.println("Browser is launched..."+BROWSER);
		}
		else
			System.out.println("Invalid browser name...");
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step4: Enter the credentials to login to application 
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step5: Click on organization link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationLnk();
		
		//Step6: Click on create new organizations look up image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step7: Enter the mandatory details to create organization
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step8: Validate Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeaderText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("Organization is created");
		}
		else
		{
			System.out.println("Organization creation failed");
		}
		
		//Step9: Navigate to contacts link
		hp.clickContactsLnk();
		
		//Step10: click on create new contacts lookup img
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsImg();
		
		//Step11: Create contact with mandatory details
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, driver, ORGNAME);
		
		//Step12: Validate for contacts
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String ContactHeader = cip.getcontactHeaderText();
		
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println(LASTNAME);
			System.out.println("Contact is created");
		}
		else
			System.out.println("Contact is not created");
		
		//Step13: Sign out
		hp.singOutOfApp(driver);

	}

}
