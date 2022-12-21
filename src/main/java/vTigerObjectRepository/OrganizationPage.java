package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	//declaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	//initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	//Business library
	/**
	 * This method will click on create organization look up img
	 */
	public void clickOnCreateOrgLookUpImg()
	{
		createOrgLookUpImg.click();
	}
	
	
	
}
