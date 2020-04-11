package com.cts.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class TestLog4jApp {
	private static Logger logger=(Logger) LogManager.getLogger(TestLog4jApp.class);

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Logging is gonna start");
		
		logger.debug("this is another debugg info....");
		logger.debug("this is debbuging information");
		logger.info("this is an info");
		logger.warn("this us warning msg");
		logger.error("this is a error msg");
		logger.fatal("this ia a ftal msg");
		System.out.println("logging completed");
 
		

	}

}
