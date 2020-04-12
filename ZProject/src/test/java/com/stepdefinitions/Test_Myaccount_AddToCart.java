package com.stepdefinitions;

import org.apache.logging.log4j.core.Logger;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import com.pages.Myaccount_AddToCart;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Myaccount_AddToCart extends Base{
	Base b = new Base();
	Myaccount_AddToCart addcart;
	
	public static Logger logger = (Logger) LogManager.getLogger(Test_Myaccount_Login.class.getName());
	

@Given("User on home page2")
public void user_on_home_page2() throws IOException {
	// Write code here that turns the phrase above into concrete actions
	prop=b.intiateproperties();
    driver=b.intiatedriver(prop.getProperty("browser"));
    driver.get(prop.getProperty("url"));
    logger.debug("Navigated to the specified url");
    addcart= new Myaccount_AddToCart(driver);
      b.startTest("Addtocart");
	
	if(driver.getTitle().equals("Automation Practice Site"))
	{
		test.log(LogStatus.PASS, "searches for a product in site");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");		
	}
}

@When("User searches the product")
public void user_searches_the_product() {
	// Write code here that turns the phrase above into concrete actions
	addcart.typename("html");
	logger.info("searched the product");
}

@When("User select the product")
public void user_select_the_product() {
	// Write code here that turns the phrase above into concrete actions
	addcart.selectlink();
	logger.info("selected the type of the product");
}

@When("User select the filter")
public void user_select_the_filter() {
	// Write code here that turns the phrase above into concrete actions
	addcart.filter1();
	logger.info("Added filter");
}

@Then("User choose the produc t")
public void user_choose_the_produc_t() {
	// Write code here that turns the phrase above into concrete actions
	addcart.selectfilter();
	logger.info("selected the final product");
	if(driver.getTitle().equals("HTML – Automation Practice Site"))
	{
		test.log(LogStatus.PASS, "choose a product and add it");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");		
	}

}

@Then("Clicks on add to basket")
public void clicks_on_add_to_basket() {
	// Write code here that turns the phrase above into concrete actions
	addcart.addtobasket();
	logger.info("Added to the basket");
}

@Then("User lands on cart page")
public void user_lands_on_cart_page() throws IOException, InterruptedException {
	// Write code here that turns the phrase above into concrete actions
	logger.info("Landed on the basket page");
	addcart.viewbasket();
	Thread.sleep(2000);
	b.takeScreenshot("AddToCart");
	
	if(driver.getTitle().equals("Basket – Automation Practice Site"))
	{
		test.log(LogStatus.PASS, "Added product is viewed on page");
	}
	else
	{
	test.log(LogStatus.FAIL, "Test Failed");		
	}
	b.endTest();
   driver.quit();
   }





}
