package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement CreateContactsLookupImg;
	
	//initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateContactsLookupImg() {
		return CreateContactsLookupImg;
	}
	
	//Business Library
	/**
	 * This method will click on CreateContactsLookupImg
	 */
	public void clickOnCreateContactsImg()
	{
		CreateContactsLookupImg.click();
	}
}
