package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.Base;

public class Myaccount_Accountdetails extends Base {

@FindBy(xpath="//ul/li[2][@id='menu-item-50']/a")
WebElement account;

@FindBy(name="username")
WebElement enteruser;

@FindBy(id="password")
    WebElement enterpass;

@FindBy(xpath="//input[@name='login']")
WebElement login;

@FindBy(linkText="Account Details")
WebElement accountdetails;

@FindBy(xpath="//input[@id='password_current']")
WebElement currentpassword;

@FindBy(xpath="//input[@id='password_1']")
WebElement newpassword;

@FindBy(xpath="//input[@id='password_2']")
WebElement confirmpassword;

@FindBy(xpath="//p/input[@name='save_account_details']")
WebElement savechanges;

@FindBy(xpath="//div[@class='woocommerce-message']")
WebElement success;

public Myaccount_Accountdetails(WebDriver d) //Browser will starts launching
    {
        driver=d;
        PageFactory.initElements(driver,this);
		driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
    }
public void myaccount() // User will enter a valid credentials
{
account.click();
}

public void sendkeys1(String susername, String spassword)
    {
         enteruser.sendKeys(susername);
         enterpass.sendKeys(spassword);
           
    }

public void login() // enter login with correct credentials
 {
 login.click();
 }
 
 public void click_accountdetails() // go for account details 
 {
 accountdetails.click();
 }
 public void credentials(String str1, String str2, String str3) //chnaging the password
 {
 currentpassword.sendKeys(str1);
 newpassword.sendKeys(str2);
 confirmpassword.sendKeys(str3);
 savechanges.submit();
 
 }
 public void success_message() //confirmation messaged on other page
 {
 System.out.println(success.getText());
 }

}