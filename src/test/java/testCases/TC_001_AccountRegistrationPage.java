package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationPage extends BaseClass{
	static String mail;
	static String pwd;
	
	@Test(groups={"regression","master"})
	public void verify_AccountRegistrationPage()
	{
		logger.info("*****starting TC_001_AccountRegistrationTest    ******");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.btnSigning();
		hp.btnReg();
		logger.info("**** Clicked on Register button *****");
		
		
		logger.info("Entering customer details:");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstname(randomeString().toUpperCase());
		regpage.setLastname(randomeString().toUpperCase());		
		regpage.setDob("2/24/1999");
		regpage.setAddress(randomeString());
		regpage.setPostcode("234567");
		regpage.setCity(randomeString());
		regpage.setState(randomeString());
		regpage.setCountry();
		regpage.setPhone(randomeNumber());
		
		mail = (randomeString()+"@gmail.com");
		System.out.println(mail);
		regpage.setEmail(mail);
		
		pwd = randomeAlphaNumeric();
		System.out.println(pwd);
		regpage.setPassword(pwd);
		
		regpage.btnRegistration();
		logger.info("Clicked on register account after filling details.........");
		
		String title = regpage.getheading();
		logger.info("Validating expected message.....");
		
		if(title.equals("Login"))
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test failed");
			Assert.fail();
		}
		
	}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("*****finished TC_001_AccountRegistrationTest ****");
		
	}

}
