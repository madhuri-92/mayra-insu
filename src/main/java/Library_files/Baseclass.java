package Library_files;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass 
{
	public WebDriver driver;
	 public void initializeBrowser()
	 {//Step-I:
			//Parameter-I: Name of the Browser
			//Parameter-II:Path of ChromeDriver.exe file
		 System.setProperty("WebDriver.Chrome.Driver", "C:\\Users\\admin\\eclipse-workspace\\Maven_Practice\\Browser\\chromedriver.exe");
		 
		 WebDriver driver=new ChromeDriver();
		 
		 //to enter URL
		 driver.get("https://demo.guru99.com/insurance/v1/index.php");
		 
			
			driver.manage().window().maximize();

		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
		 
	 }
	
	
	
	
	
	
	

}


