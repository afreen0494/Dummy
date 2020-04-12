package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Deletecartitem extends Base{
	@FindBy(xpath="//ul/li/a")
	WebElement shop;
	
	@FindBy(xpath="//a[text()='Add to basket']")
	WebElement additem;
	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement viewitem;	 
	
	@FindBy(xpath="//body//form//tr//td/a[@class='remove']")
	WebElement deleteitem;
	
	@FindBy(xpath="//div[@class='woocommerce-message']")
	WebElement message;
	
	public Myaccount_Deletecartitem(WebDriver d) //launching browser with given URL
    {
        driver=d;
        PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }

	public void click_shop() //click on shop
	{
		shop.click();
	}
	public void click_additem() //add the wanted item
	{
		additem.click();
	}
	public void click_viewitem() // view that item added
	{
		viewitem.click();
	}
	public void click_deleteitem() // delete the selected item
	{
		deleteitem.click();
	}
	public void delete_message() //deleted messaged on page
	{
		message.click();
	}
}
