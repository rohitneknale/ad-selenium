package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	//Business logic
	/**
	 * This method will return header text of organization created
	 * @return 
	 * 
	 */
	public String getOrganizationHeaderText()
	{
		return orgHeaderText.getText();
	}

}
