package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Billingaddress extends Base {
	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;
	@FindBy(name="username")
	WebElement user;	
	@FindBy(name="password")
	WebElement pass;	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;	
	@FindBy(linkText="Addresses")
	WebElement address;
	@FindBy(linkText="Edit")
	WebElement edit;
	@FindBy(name="billing_first_name")
	WebElement firstname;
	@FindBy(name="billing_last_name")
	WebElement lastname;
	@FindBy(name="billing_company")
	WebElement companyname;
	@FindBy(name="billing_email")
	WebElement email;
	@FindBy(name="billing_phone")
	WebElement phone;
	@FindBy(name="billing_address_1")
	WebElement address1;
	@FindBy(name="billing_address_2")
	WebElement address2;
	@FindBy(name="billing_city")
	WebElement city;
	@FindBy(xpath="//input[@name='save_address']")
	WebElement saving;
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement success;
	public Myaccount_Billingaddress(WebDriver d) // launches the browser with given url
	{
		driver=d;
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 }
	public void myaccount() //clicks on my account option
	{
		account.click();
	}
	public void sendKeys1(String username,String password) //enters with valid creadentials
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		
	}
	public void login() // click on login
	{
		login.click();
		
	}
	public void click_address() //select address option
	{
		address.click();
	}
	public void click_edit() //choose edit
	{
		edit.click();
	}
	public void credentials(String str1,String str2,String str3,String str4,String str5,String str6,String str7,String str8) //enter all the details
	{
		firstname.clear();
		firstname.sendKeys(str1);
		lastname.clear();
		lastname.sendKeys(str2);
		companyname.clear();
		companyname.sendKeys(str3);
		email.clear();
		email.sendKeys(str4);
		phone.clear();
		phone.sendKeys(str5);
		address1.clear();
		address1.sendKeys(str6);
		address2.clear();
		address2.sendKeys(str7);
		city.clear();
		city.sendKeys(str8);
	}
	public void click_savechanges() //click on savechanges
	{
		saving.click();
	}
	public void success_message() // success messaged will displayed
	{
		System.out.println(success.getText());
	}
	
	

}
