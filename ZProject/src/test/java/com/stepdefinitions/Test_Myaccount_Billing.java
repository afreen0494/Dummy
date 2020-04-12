package com.stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import com.cts.log4j.TestLog4jApp;
import com.pages.Myaccount_Billingaddress;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Billing extends Base {
	Base b=new Base();
	Myaccount_Billingaddress acc_billing;
	private static Logger logger=(Logger) LogManager.getLogger(TestLog4jApp.class);

	@Given("User on home page1")
	public void user_on_home_page1() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.intiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		logger.debug("Entered to home page");
	}

	@Given("User enters to login page")
	public void user_enters_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
	    acc_billing=new Myaccount_Billingaddress(driver);

		acc_billing.myaccount();
		logger.info("Navigated to login page");
		
	    
	}

	@When("User enters details and clicks login button")
	public void user_enters_details_and_clicks_login_button() {
		// Write code here that turns the phrase above into concrete actions
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
	   acc_billing.sendKeys1(un, pwd);
	   acc_billing.login();
		logger.info("Recieved the user details and proceed by login");
	    b.startTest("BiilingAddress");
		
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "login into page");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}

	    
	}

	@When("User clicks on Address")
	public void user_clicks_on_Address() {
		// Write code here that turns the phrase above into concrete actions
		acc_billing.click_address();
		logger.error("Naviigate the address");

	}

	@When("User click on edit option")
	public void user_click_on_edit_option() {
		// Write code here that turns the phrase above into concrete actions
	acc_billing.click_edit();
	logger.error("Navigate the edit");

	}

	@Then("Start entering details {string} {string} {string} {string} {string} {string} {string} {string}")
	public void start_entering_details(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		// Write code here that turns the phrase above into concrete actions
	   acc_billing.credentials(string, string2, string3, string4, string5, string6, string7, string8);
		logger.info("Entered required details");
		if(driver.getTitle().equals("My Account – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "enter all credentials");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}

	}

	@Then("Click on savechanges")
	public void click_on_savechanges() {	
		// Write code here that turns the phrase above into concrete actions
	acc_billing.click_savechanges();
	logger.info("Changes been saved");

	}
	@Then("User get saving notification")
	public void user_get_saving_notification() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("Saving information on screen");
	       acc_billing.success_message();
	       Thread.sleep(2000);
			b.takeScreenshot("Report_BillingAddress");
			
			if(driver.getTitle().equals("My Account – Automation Practice Site"))
			{
				test.log(LogStatus.PASS, "Saved given adrress details");
			}
			else
			{
			test.log(LogStatus.FAIL, "Test Failed");		
			}
			b.endTest();
           driver.quit();
	}
}
