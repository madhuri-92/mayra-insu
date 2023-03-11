package Module_pomclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_login 
{
	//POM I
	
		//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation
		
	@FindBy(xpath="//input[@autofocus='autofocus']") private WebElement Email;
	 
	@FindBy(xpath="//input[@id='password']") private WebElement password;

	@FindBy(xpath="//input[@name='submit']") private WebElement loginbtn;

	//2. Initialize within a constructor with access level public using pagefactory

	public Insurance_login(WebDriver driver) 
	{
		PageFactory.initElements(driver,this);
		
		}

	//3. Utilize within a method with access level public

	public void EnterEmail(String EmailAddress)

	{
		Email.sendKeys(EmailAddress);
	}
	public void EnterPassword(String Pass)

	{
		password.sendKeys(Pass);
		}
	public void Loginbtn()
	{
		loginbtn.click();
		
	}
	}




