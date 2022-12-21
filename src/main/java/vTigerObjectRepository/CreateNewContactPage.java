package vTigerObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling:: img[@title='Select']")
	private WebElement organizationImg;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getOrganizationImg() {
		return organizationImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Business library
	/**
	 * This method will create contact  with organization
	 * @param lastname
	 */
	public void createNewContact(String lastname)
	{
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * This method will create contact by using driver and orgname
	 * @param lastname
	 * @param driver
	 * @param OrgName
	 */
	public void createNewContact(String lastname, WebDriver driver, String OrgName)
	{
		lastnameEdt.sendKeys(lastname);
		organizationImg.click();
		switchTowindow(driver, "Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchTowindow(driver, "Contacts");
		saveBtn.click();
	}
}
