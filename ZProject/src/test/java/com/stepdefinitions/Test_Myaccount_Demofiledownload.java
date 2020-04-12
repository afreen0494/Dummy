package com.stepdefinitions;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pages.Myaccount_Demofiledownload;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Demofiledownload extends Base{
	Base b = new Base();
	Myaccount_Demofiledownload down_file;
	
	public static Logger logger = LogManager.getLogger(Test_Myaccount_Demofiledownload.class.getName());
	
	@Given("User on home page4")
	public void user_on_home_page4() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.intiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
	    driver.manage().window().maximize();
	    logger.debug("Navigated to the specified url");
	    down_file= new Myaccount_Demofiledownload(driver);
	}

	@When("User clicks on Demosite")
	public void user_clicks_on_Demosite() {
		// Write code here that turns the phrase above into concrete actions
		logger.error("clicks on Demosite");
		down_file.Click_Demosite();
	}


	@When("User clicks on Download file")
	public void user_clicks_on_Download_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Clicking on download file");
		down_file.Download_file();
	}

	@When("User enters the data")
	public void user_enters_the_data() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Entering the data");
		down_file.Enter_data();
		   b.startTest("filedownload");
		if(driver.getTitle().equals("File input - Multi select"))
		{
			test.log(LogStatus.PASS, "enter some text to download");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	}

	@When("User generates the file")
	public void user_generates_the_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Generating the file");
		down_file.generate_file();
	}

	@When("User downloads the file")
	public void user_downloads_the_file() {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Downloading the file");
		down_file.Download_file1();
		if(driver.getTitle().equals("File input - Multi select"))
		{
			test.log(LogStatus.PASS, "downloaded successfully");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
		b.endTest();
	}

	@Then("File is downloaded")
	public void file_is_downloaded() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("File is downloaded");
		Thread.sleep(2000);
		b.takeScreenshot("Demofiledownload");
		down_file.file_downloaded();
		
	}


}
