package com.stepdefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cts.log4j.TestLog4jApp;
import com.pages.Myaccount_Login;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Test_Myaccount_Login extends Base{
	Base b=new Base();
	Myaccount_Login acc_login;
	private static Logger logger=(Logger) LogManager.getLogger(TestLog4jApp.class);

@Given("User on home page")
public void user_on_home_page() throws IOException {
	// Write code here that turns the phrase above into concrete actions
    prop=b.intiateproperties();
    driver=b.intiatedriver(prop.getProperty("browser"));
    driver.get(prop.getProperty("url"));
	logger.debug("Navigated the home page");

}

@Given("User lands on login page")
public void user_lands_on_login_page() {
	// Write code here that turns the phrase above into concrete actions
    acc_login=new Myaccount_Login(driver);

	acc_login.myaccount();
	logger.info("Entered to login page");    
}	
@When("User enters valid username and password")
public void user_enters_valid_username_and_password() throws IOException {
	// Write code here that turns the phrase above into concrete actions
     String[] names =new String[2];
     names=b.datadriven_excel();
     String un=names[0];
     String pwd= names[1];
   acc_login.sendKeys1(un, pwd);
	logger.info("Recieved the user details");
}
@When("User clicks on login button")
public void user_clicks_on_login_button() {
	// Write code here that turns the phrase above into concrete actions
	acc_login.login();
	logger.info("Proceed for login");    
}
@Then("User lands on Weclome page")
public void user_lands_on_Weclome_page() throws IOException, InterruptedException {
	// Write code here that turns the phrase above into concrete actions
	logger.info("Navigated to user's home page");
    acc_login.loginsucess();
    Thread.sleep(2000);
	b.takeScreenshot("Login");
	b.startTest("Login");
	
	if(driver.getTitle().equals("My Account – Automation Practice Site"))
	{
		test.log(LogStatus.PASS, "Successfully login completed");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");		
	}
	b.endTest();
     driver.quit();
}
}
