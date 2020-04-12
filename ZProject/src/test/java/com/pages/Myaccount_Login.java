package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Login extends Base {
	@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
	WebElement account;
	
	@FindBy(name="username")
	WebElement user;
	
	@FindBy(name="password")
	WebElement pass;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']")
	WebElement home;
	
	public Myaccount_Login(WebDriver d) //browser will launches with the given URL
	{
		driver=d;
		PageFactory.initElements(driver,this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 }
	public void myaccount() //select on my account
	{
		account.click();
	}
	public void sendKeys1(String username,String password) // User enters with the valid credentials
	{
		user.sendKeys(username);
		pass.sendKeys(password);
		
	}
	public void login() //clicks on login 
	{
		login.click();
		
	}
	public void loginsucess() //success message will displayed on the page
	{
		System.out.println(home.getText());
	}

}
