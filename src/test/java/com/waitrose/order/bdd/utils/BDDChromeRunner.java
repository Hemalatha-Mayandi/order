package com.waitrose.order.bdd.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.waitrose.order.bdd.utils.WebConnector.Browsers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@H", 
                 features = "src/test/resources/com/waitrose/order/bdd/features",
                 monochrome = true,  
                 strict = true, 
                	// dryRun = true,
                 format = {"pretty", "html:target/cucumber" }, 
                 glue = { "com.waitrose.order.bdd.stepdefs"})

public class BDDChromeRunner {
	
	@BeforeClass
	public static void setUp() {
		WebConnector.getInstance().initialiseDriver(Browsers.valueOf("Chrome"));
	}

	/*@AfterClass
	public static void tearDown() {
		WebConnector.driver.quit();
	}*/

}
