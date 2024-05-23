package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="/html/body/app-root/div/app-overview/h1")
	WebElement msgHeading;
	
	@FindBy(id="menu")
	WebElement lnkprofile;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[4]/ul/li[7]/a")
	WebElement lnkLogout;
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return(msgHeading.isDisplayed());
		} 
		catch(Exception e)
		{
			return(false);
		}
	}

	public void myProfile()
	{
		lnkprofile.click();
	
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

}
