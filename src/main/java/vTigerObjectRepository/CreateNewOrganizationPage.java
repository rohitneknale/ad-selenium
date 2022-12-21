package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary{
	
	//initialization
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//declaration
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business logic
	/**
	 * This will create Organization with mandatory details 
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		OrgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create organization with organization name and industry type
	 * @param ORGNAME
	 * @param industryType
	 */
	public void createNewOrganization(String ORGNAME,String industryType )
	{
		OrgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown, industryType);
	}
	
	
	
	
	

}
