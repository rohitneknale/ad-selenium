package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
	
	//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;

	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;

	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}
	
	public WebElement getProductsLnk() {
		return ProductsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutBtn() {
		return SignOutLnk;
	}
	
	/**
	 * This method will click on organization link
	 */
	public void clickOrganizationLnk()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickContactsLnk()
	{
		ContactsLnk.click();
	}
	
	/**
	 * This method will perform sign out of application 
	 * @param driver
	 */
	public void singOutOfApp(WebDriver driver)
	{
		mouseHoverOn(driver,AdministratorImg);
		SignOutLnk.click();
	}
}