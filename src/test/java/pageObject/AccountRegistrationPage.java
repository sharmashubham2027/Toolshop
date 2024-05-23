package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "first_name")
	WebElement txtFirstname;
	
	@FindBy(id = "last_name")
	WebElement txtLastname;
	
	@FindBy(id = "dob")
	WebElement txtDateOfBirth;
	
	@FindBy(id = "address")
	WebElement txtAddress;
	
	@FindBy(id = "postcode")
	WebElement txtPostcode;
	
	@FindBy(id = "city")
	WebElement txtCity;
	
	@FindBy(id = "state")
	WebElement txtState;
	
	@FindBy(xpath="//select[@id='country']//option[5]")
	WebElement txtCountry;
	
	@FindBy(id = "phone")
	WebElement txtphone;
	
	@FindBy(id = "email")
	WebElement txtEmail;
	
	@FindBy(id = "password")
	WebElement txtPassword;
	
	@FindBy(xpath="//button[contains(text(),'Register')]")
	WebElement btnRegister;
	
	@FindBy(xpath="//h3[contains(text(),'Login')]")
	WebElement title;
	
	
	
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setDob(String dob)
	{
		txtDateOfBirth.sendKeys(dob);
	}
	
	public void setAddress(String add)
	{
		txtAddress.sendKeys(add);
	}
	
	public void setPostcode(String code)
	{
		txtPostcode.sendKeys(code);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void setCountry()
	{
		txtCountry.click();
	}
	
	public void setPhone(String phone)
	{
		txtphone.sendKeys(phone);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void btnRegistration()
	{
		btnRegister.click();
	}
	
	public String getheading()
	{
		return(title.getText());
	}

}
