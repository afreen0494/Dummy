package com.stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.pages.Myaccount_Accountdetails;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Accountdetails extends Base {
	Base b1 = new Base();
	Myaccount_Accountdetails my_accdet;

	public static Logger logger = (Logger) LogManager.getLogger(Test_Myaccount_Login.class.getName());
	
	
	@Given("User on home page3")
	public void user_on_home_page3() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		prop=b1.intiateproperties();
	    driver=b1.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		logger.debug("Entered to home page");
		b1.startTest("Accountdetails Updating");
		
		if(driver.getTitle().equals("Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "Browser opened with given URL");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	}

	@Given("User on login page")
	public void user_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		my_accdet= new Myaccount_Accountdetails(driver);
		my_accdet.myaccount();
		logger.info("Navigated to the Myaccount");
	}

	@When("User clicks login button1")
	public void user_clicks_login_button1() {
		// Write code here that turns the phrase above into concrete actions
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		my_accdet.sendkeys1(un, pwd);
		logger.info("Entered username and password");
		my_accdet.login();
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "logined successfully");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	}

	@When("User clicks on Accountdetails1")
	public void user_clicks_on_Accountdetails1() {
		// Write code here that turns the phrase above into concrete actions
			logger.error("Navigating to your account");
			my_accdet.click_accountdetails();
	}

	@When("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		my_accdet.credentials(string, string2, string3);
		logger.info("Entered new password");
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "changed credentials in My Account");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	}

	@Then("User lands on password changed successfully")
	public void user_lands_on_password_changed_successfully() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Password changed successfully");
		my_accdet.success_message();
		Thread.sleep(2000);
		b1.takeScreenshot("Accountdetails");
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "Password chnaged successfuuly");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
		b1.endTest();
		driver.quit();
	}

}
