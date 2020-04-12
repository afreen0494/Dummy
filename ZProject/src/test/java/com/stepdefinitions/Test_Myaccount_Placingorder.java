package com.stepdefinitions;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pages.Myaccount_Placingorder;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_Placingorder extends Base{
	Base b=new Base();
	Myaccount_Placingorder acc_placeorder;
	private static Logger logger=(Logger) LogManager.getLogger(Myaccount_Placingorder.class);
	
	@Given("Enters the home page")
	public void enters_the_home_page() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.intiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		logger.debug("Entered to home page");
		acc_placeorder = new Myaccount_Placingorder(driver);

	}

	@When("User login with valid credentials")
	public void user_login_with_valid_credentials() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.myaccount();
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		acc_placeorder.sendKeys1(un, pwd);
		acc_placeorder.login();
		logger.info("user logins with valid cridentials");
		   b.startTest("placingorder");
			
					if(driver.getTitle().equals("My Account – Automation Practice Site"))
					{
						test.log(LogStatus.PASS, "login sucesfully");
					}
					else
					{
					test.log(LogStatus.FAIL, "Test Failed");		
					}
	}

	@Then("User clicks on shop")
	public void user_clicks_on_shop() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_shop();
		logger.error("click on the shop");
	}

	@Then("User select an item to basket and view the product")
	public void user_select_an_item_to_basket_and_view_the_product() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_addtobasket();
		acc_placeorder.click_viewbasket();
		logger.debug("user needs to select an iteam and add it to cart, later view it");
		if(driver.getTitle().equals("Basket – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "add item");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	
	}

	@Then("Clicks on proceed")
	public void clicks_on_proceed() {
		// Write code here that turns the phrase above into concrete actions
	  acc_placeorder.click_proceed();
	  logger.error("Clicks on proceed button");
	}

	@Then("Moveon to place order")
	public void moveon_to_place_order() {
		// Write code here that turns the phrase above into concrete actions
		acc_placeorder.click_placeorder();
		logger.error("select place order");
		if(driver.getTitle().equals("Checkout – Automation Practice Site"))
		{
			test.log(LogStatus.PASS, "place order successfully");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");		
		}
	}

	@Then("User lands on other page which shows order is successfull")
	public void user_lands_on_other_page_which_shows_order_is_successfull() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		logger.info("lands on another page with a message");
		acc_placeorder.order_message();
		Thread.sleep(2000);
		b.takeScreenshot("Placingorder");
		b.endTest();
		driver.quit();
	}

}
