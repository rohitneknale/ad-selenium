package vTigerObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//rule1:create a separate java class for every web page 
	
	//rule2: identify the elements @FindBy, @FindBys, @FindAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//rule3: Create a constructor to initialize these variables
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	//rule4: Provide getter method to access these variables
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswoedEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Library
	/**
	 * This method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username, String password)
	{
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
}
