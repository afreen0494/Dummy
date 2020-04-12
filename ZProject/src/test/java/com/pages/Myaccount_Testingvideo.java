package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Testingvideo extends Base{
	@FindBy(xpath="//ul/li[5][@class='menu-item menu-item-type-custom menu-item-object-custom']/a")
	WebElement demosite;
	
	@FindBy(xpath="//ul/li[7]/a")
	WebElement video;
	
	@FindBy(xpath="//ul/li[7]/ul/li[2]/a")
	WebElement vimeo;
	
	@FindBy(xpath="//div/iframe")
	WebElement play;
	
	public Myaccount_Testingvideo(WebDriver d) //lauching browser with proper url
    {
        driver=d;
        PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }

	public void click_demosite() // clicks on demosite
	{
		demosite.click();
	}

	public void Download_file() //choose vimeo option and it directs to other page
	{
		Actions actions = new Actions(driver);
		if(video.isDisplayed())
		{
			actions.moveToElement(video).build().perform();
			if(vimeo.isDisplayed())
			{
				actions.moveToElement(vimeo).click().build().perform();
			}
		}
		 
	}
	
	public void playclick() //click on video to play
	{
		Actions actions1 = new Actions(driver);
		if(play.isDisplayed())
		{
			actions1.moveToElement(play).click().build().perform();
		}
		
		
	}
	
	

}
