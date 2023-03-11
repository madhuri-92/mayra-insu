package Library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utilityclass
{
	//Automation TE:@Madhuri
	//Date:20/02/2023
	//Day:Monday
	//Fetch data from property file
		
	@Test
	public static String getDatafromPF(String key) throws IOException
	{
		//to reach upto property file
		
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Maven_Practice\\propertyfile.properties");
		
		//create object of properties class
		Properties propfile=new Properties();
		
		//to open prop file 
		propfile.load(file);
		
		//to fetch data from property file
		String value1=propfile.getProperty(key);  //EM    //PSW
		
		return value1;     //saradeg41@gmail.com //Sai@1114
		
		
	}
	//Automation TE:@Madhuri
	//Date:20/02/2023
	//Day:Monday
	//Fetch data from Excel sheet

	@Test
	public static String getdataFromExcelsheet(int RowIndex, int CellIndex) throws  IOException
	{
		//To reach upto Excelsheet
		  FileInputStream file=new  FileInputStream("C:\\Users\\admin\\eclipse-workspace\\Maven_Practice\\Testdata\\Spreadsheet.xlsx");  
		  
		  org.apache.poi.ss.usermodel.Sheet  Sh=WorkbookFactory.create(file).getSheet("Sheet2");
		                         //3                 //0
		String  Value2=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();   //Insurance Broker System
		

		
		return Value2;
		
	}
		
	@Test
	public static void CaptureScreenshot(WebDriver driver,int TestCaseID) throws IOException
	{
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(Source);
		
		File Destination=new File("C:\\Users\\admin\\eclipse-workspace\\Maven_Practice\\Screenshots\\."+TestCaseID+".jpg");

	FileHandler.copy(Source, Destination);

	}






		
	}



