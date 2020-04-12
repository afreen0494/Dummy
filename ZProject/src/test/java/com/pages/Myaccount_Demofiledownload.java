package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Demofiledownload extends Base {
	
	@FindBy(xpath="//ul/li[5][@class='menu-item menu-item-type-custom menu-item-object-custom']/a")
	WebElement demosite;
	
	@FindBy(xpath="//ul/li[9]/a")
	WebElement more;
	
	@FindBy(xpath="//ul/li[9]/ul/li[3]/a")
	WebElement file;
	
	@FindBy(xpath="//div/textarea[@id='textbox']")
	WebElement textbox;
	
	@FindBy(xpath="//div/button[@id='createTxt']")
	WebElement generate;
	
	@FindBy(xpath="//div/a[@id='link-to-download']")
	WebElement download;
	
	public Myaccount_Demofiledownload(WebDriver d) //browser strats lauching for our site
    {
        driver=d;
        PageFactory.initElements(driver,this);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
	public void Click_Demosite() //click on demosite
	{
		demosite.click();
	}
	public void Download_file() //select file download option
	{
		Actions actions = new Actions(driver);
		if(more.isDisplayed())
		{
			actions.moveToElement(more).build().perform();
			if(file.isDisplayed())
			{
				actions.moveToElement(file).click().build().perform();
			}
		}
		
	}
	public void Enter_data() //enter the required data
	{
		textbox.clear();
		textbox.sendKeys("This is afreen." + Keys.ENTER + "I am trying to generate a file and download the file");
	}
	public void generate_file() //click on generate file
	{
		generate.click();
	}
	
	public void Download_file1() //click on download 
	{
		download.click();
	}
	
	public void file_downloaded() // file downloded successfully then page will quit
	{
		driver.quit();
	}
	
	
	
}