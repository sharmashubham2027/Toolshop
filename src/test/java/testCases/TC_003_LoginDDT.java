package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email, String password, String exp)
	{
		MyAccountPage macc = new MyAccountPage(driver);
		try
		{
		HomePage hp = new HomePage(driver);
		hp.btnSigning();
		
		LoginPage lp = new LoginPage(driver);	
		lp.setemail(email);
		lp.setpassword(password);
		lp.loginButton();
		
		
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				Thread.sleep(3000);
				macc.myProfile();
				Thread.sleep(2000);
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				lp.clearEmail();
				Thread.sleep(1000);
				lp.clearPassword();
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetPage==true)
			{
				Thread.sleep(3000);
				macc.myProfile();
				Thread.sleep(2000);
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				lp.clearEmail();
				Thread.sleep(1000);
				lp.clearPassword();
				Assert.assertTrue(true);
			}
		}
		
		
		
		}catch(Exception e)
		{
			
			Assert.fail();
		}
	}
}
