package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Placingorder extends Base {
	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;	
	@FindBy(name="username")
	WebElement user;	
	@FindBy(name="password")
	WebElement pass;	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	@FindBy(xpath="//ul/li[1]/a")
	WebElement shop;
	@FindBy(xpath="//ul/li[3]/a[text()='Add to basket']")
	WebElement addbasket;	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement view;
	@FindBy(xpath="//div[@class='wc-proceed-to-checkout']/a")
	WebElement proceed;
	@FindBy(xpath="//div/input[@value='Place order']")
	WebElement placeorder;
	@FindBy(xpath="//p[@class='woocommerce-thankyou-order-received']")
	WebElement message;
	public Myaccount_Placingorder(WebDriver d) //browser starts launching
	{
		driver=d;
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void myaccount() //click on myaccount
	{
		account.click();
	}
	public void sendKeys1(String username,String password) // enter with valid credentials
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		
	}
	public void login() // click on login button
	{
		login.click();
		
	}
	public void click_shop() // click on shop
	{
		shop.click();			
	}
	public void click_addtobasket() //click on addto basket
	{
		addbasket.click();
	}
	public void click_viewbasket() // view the basket
	{
		view.click();
	}
	public void click_proceed() // click on proceed for furthur process
	{
		proceed.click();
	}
	public void click_placeorder() //select place order 
	{
		placeorder.click();
	}
	public void order_message() //confirmation message about the order 
	{
		System.out.println(message.getText());
	}
}
