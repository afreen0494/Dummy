
package com.runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) //to execute this test case as cucumber test
@CucumberOptions //this annotation is used to run your cucumber file with different parameters
         (
		features="src/main/resources/ZProjectFolder",
		tags= {"@TC_login or @TC_Billing or @TC_AddToCart or @TC_Accountdetails or @TC_Demofiledownload or @TC_Placingorder or @TC_Deletecartitem or @TC_Testingvideo"},
		glue= {"com.stepdefinitions"},
				plugin= {"html:reports.html",
			    		 "json:JSONReport", "junit:target/myreport.xml"},
				strict=true
		
		)
@SuiteClasses({}) //its acts as collection of tests
public class AllTests_Runner {
	
}
