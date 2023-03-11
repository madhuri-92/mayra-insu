package Module_testclass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_files.BaseClass1;
import Library_files.UtilityClass2;
import Module_pomclass.Insurance_Broker_Webpage1;
import Module_pomclass.Insurance_Login1;

public class TestClass1 extends BaseClass1
{//public WebDriver driver;
	//InitializeBrowser() 
	
	Insurance_Login1 Login;
	Insurance_Broker_Webpage1 Broker;
	
	int TestCaseID;

	@BeforeClass
	public void OpenBrowser() 
	{
		InitializeBrowser();
		
		 //Create Object Of POM-I Class
		Login=new Insurance_Login1(driver);
		
		//Create object of POM-II Class
        Broker=new Insurance_Broker_Webpage1(driver);

	}
	
	
	@BeforeMethod
	public void loginToApp() throws IOException 
	{
		Login.EnterEmail(UtilityClass2.getDatafromPF("EM")); //saradeg41@gmail.com
		
		Login.EnterPassowrd(UtilityClass2.getDatafromPF("PSW"));  //Sai@1117
		
		Login.ClickLoginBtn();
		
	}
	
	@Test(priority=1)                                 //Test Case/method
	public void VerifyEmailAddress() throws EncryptedDocumentException, IOException 
	{
	
		TestCaseID=100;
		
		//verify Email Address
		String ActualEmail=Broker.getEmail();   //saradeg41@gmail.com

		String ExpectedEmail=UtilityClass2.getdataFromExcelsheet(2, 0);  //saradeg41@gmail.com
	
		Assert.assertEquals(ActualEmail,ExpectedEmail);		
	}
	
	@Test(priority=2) 
	public void VerifyTitle() throws EncryptedDocumentException, IOException
	{    
		TestCaseID=101;
		
		String ActualTitle=driver.getTitle();  //Insurance Broker System
		
		String ExpectedTitle=UtilityClass2.getdataFromExcelsheet(3, 0);  //Insurance Broker System1
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	
	@AfterMethod                          //Fail
	public void LogoutFromApp(ITestResult Result) throws IOException   //Pass Fail
	{       //Fail                   //Fail
		if(Result.getStatus()==ITestResult.FAILURE) 
		{
			UtilityClass2.CaptureScreenshot(driver, TestCaseID);  //101
		}
		
		
		
		Broker.ClickLogoutBtn();
	}
	
	@AfterClass
	public void CloseBrowser() 
	{
		driver.close();
	}
	
	
}


