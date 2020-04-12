package com.stepdefinitions;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.pages.Myaccount_Deletecartitem;
import com.pages.Myaccount_Placingorder;
import com.pages.Myaccount_Testingvideo;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.Base;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Test_Myaccount_Testingvideo extends Base {
	
	Base b=new Base();
	Myaccount_Testingvideo acc_playing;
	private static Logger logger=(Logger) LogManager.getLogger(Myaccount_Placingorder.class);
	
	@Given("User lands on home page5")
	public void user_lands_on_home_page5() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		prop=b.intiateproperties();
	    driver=b.intiatedriver(prop.getProperty("browser"));
	    driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		    logger.debug("Navigated to the specified url");
		    b.startTest("videoplay");
			
			if(driver.getTitle().equals("Automation Practice Site"))
			{
				test.log(LogStatus.PASS, "Navigated the URL site");
			}
			else
			{
			test.log(LogStatus.FAIL, "Test Failed");		
			}

	}

	@Given("clicks on demo site")
	public void clicks_on_demo_site() {
		// Write code here that turns the phrase above into concrete actions
		acc_playing=new Myaccount_Testingvideo(driver);
		logger.error("clicks on demo site");
		acc_playing.click_demosite();
	
		
	}

	@Given("select the vimeo")
	public void select_the_vimeo() {
		// Write code here that turns the phrase above into concrete actions
		logger.trace("select the vimeo option");
		acc_playing.Download_file();
		   b.startTest("videoplay");
			
					if(driver.getTitle().equals("Register"))
					{
						test.log(LogStatus.PASS, "select the video");
					}
					else
					{
					test.log(LogStatus.FAIL, "Test Failed");		
					}
	}

	@Then("Play the obtained video")
	public void play_the_obtained_video() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
	    logger.info("Clicked on play");
		acc_playing.playclick();
	    Thread.sleep(15000);
	    b.takeScreenshot("vimeo video");
	    b.startTest("videoplay");
		
	 			if(driver.getTitle().equals("Youtube"))
	 			{
	 				test.log(LogStatus.PASS, "viseo started playing");
	 			}
	 			else
	 			{
	 			test.log(LogStatus.FAIL, "Test Failed");		
	 			}
	 			b.endTest();
	    driver.quit();

	}


}
