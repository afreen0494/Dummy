package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class Base<TakeScreenshot> {
	
	public WebDriver driver;
	public Properties prop;
	
	public static ExtentTest test;
	public static ExtentReports report;
	
	public Properties intiateproperties() throws IOException
	{
		prop=new Properties();
		FileInputStream ip=new FileInputStream("C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/src/test/resources/Testdata/config.properties");
		prop.load(ip);
		return prop;
	}
	public WebDriver intiatedriver(String Browsername)
	{
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/src/test/resources/Driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(Browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/src/test/resources/Driver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		return driver;
	}
	public void takeScreenshot(String filename) throws IOException
	{
		File file=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/src/test/resources/Screenshots/"+filename+".jpg"));
	}
	
	public String[] datadriven_excel() throws IOException
	{
		String[] names=new String[2];
		FileInputStream fin;
		fin =new FileInputStream("C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/src/test/resources/Testdata/datadrivenexcel.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fin);
		XSSFSheet sh=wb.getSheet("Sheet1");
		names[0]= sh.getRow(1).getCell(0).getStringCellValue();
		names[1]= sh.getRow(1).getCell(1).getStringCellValue();
		
		return names;
				
	}
	public static  void startTest(String str)
	{
		report = new ExtentReports("C:/Users/afreen/eclipse-workspace/selenium/pom/ZProject/Extent reports/"+str+".html");
		test = report.startTest(str);
	}
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}

}
