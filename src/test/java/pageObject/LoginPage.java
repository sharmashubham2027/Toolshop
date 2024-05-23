package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email")
	WebElement txtemail;
	
	@FindBy(id="password")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@class='btnSubmit']")
	WebElement btnLogin;
	
	public void setemail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setpassword(String email)
	{
		txtpassword.sendKeys(email);
	}
	
	public void loginButton()
	{
		btnLogin.click();
	}
	
	public void clearEmail()
	{
		txtemail.clear();
	}
	
	public void clearPassword()
	{
		txtpassword.clear();
	}
}
