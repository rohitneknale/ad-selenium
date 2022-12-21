package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {
	
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactText;
	
	//initialization
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getContactText() {
		return contactText;
	}
	
	
	//Business logic
	/**
	 * This method will return contact header text
	 * @return
	 */
	public String getcontactHeaderText()
	{
		return contactText.getText();
	}

}
