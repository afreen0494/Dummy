package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_AddToCart extends Base{

	@FindBy(xpath="//*[@id=\"s\"]")
	WebElement search;
	
	@FindBy(xpath="//li[@class='cat-item cat-item-19']/a")
	WebElement links;
	
	@FindBy(xpath="//select[@class='orderby']")
	WebElement filter;
	
	@FindBy(xpath="//select[@class='orderby']/option[@value='menu_order']")
	WebElement hightolow;
	
	@FindBy(xpath="//a[text()='Add to basket']")
	WebElement addbasket;
	
	@FindBy(xpath="//a[text()='View Basket']")
	WebElement view;
	
	@FindBy(xpath="//tbody/tr/td[3]/a")
	WebElement msg;
	
	public Myaccount_AddToCart(WebDriver d) //lauches the browser with given site
    {
        driver=d;
        PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
	
	public void typename(String name) //search the needed product
	{
		search.sendKeys(name);
		search.sendKeys(Keys.ENTER);
	}
	
	public void selectlink() //click on product option
	{
		links.click();
	}
	
	public void filter1() //select filter
	{
		filter.click();
	}
	public void selectfilter() //choose wanted filter
	{
		hightolow.click();
	}
	public void addtobasket() //select addtocart
	{
		addbasket.click();
	}
	public void viewbasket() //view the basket for confirmation
	{
		view.click();
		System.out.println(msg.getText());
	}
}