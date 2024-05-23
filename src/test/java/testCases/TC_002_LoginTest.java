package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	
	@Test(groups={"sanity","master"})
	public void verify_LoginPage()
	{
			
		logger.info("*******  Starting TC_002_LoginTest  ********");
		
		try 
		{
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.btnSigning();
		logger.info("****   clicked on Signing button   ***");
		
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		logger.info("**** providing valid details for logging ****");	
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.loginButton();
		
		
		//My AccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();	
		
			if(targetPage==true)
			{
				logger.info("Login test passed.....");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("Login test failed....");
				Assert.fail();
			}
		
		}catch(Exception e)
		{
			Assert.fail();
		}

		logger.info("*******  Finished TC_002_LoginTest  ********");	
	}
}
