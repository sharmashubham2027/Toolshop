package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement btnSignIn;
	
	@FindBy(xpath="//a[contains(text(),'Register your account')]")
	WebElement btnRegister;
	
	
	public void btnSigning()
	{
		btnSignIn.click();
	}
	
	public void btnReg()
	{
		btnRegister.click();
	}
}
