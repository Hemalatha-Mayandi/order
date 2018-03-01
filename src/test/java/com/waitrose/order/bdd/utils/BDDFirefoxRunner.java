package com.waitrose.order.bdd.utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;

import com.waitrose.order.bdd.utils.WebConnector;
import com.waitrose.order.bdd.utils.WebConnector.Browsers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@smoke-test", 
                 features = "src/test/resources/com/waitrose/order/bdd/features",
                 monochrome = true,  
                 strict = true, 
                 //dryRun = true,
                 format = {"pretty", "html:target/cucumber" }, 
                 glue = { "com.waitrose.order.bdd.stepdefs"})

public class BDDFirefoxRunner {
	
	@BeforeClass
	public static void setUp() {
		WebConnector.getInstance().initialiseDriver(Browsers.valueOf("Firefox"));
	}

//	@AfterClass
//	public static void tearDown() {
//		WebConnector.driver.quit();
//	}
}
