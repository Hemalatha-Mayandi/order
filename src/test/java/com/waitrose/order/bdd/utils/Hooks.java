package com.waitrose.order.bdd.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
	private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

	private void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenShot = ((TakesScreenshot) WebConnector.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenShot, "image/png");
			} catch (WebDriverException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		LOG.info("###### Finished Scenario : {} ######", scenario.getName() + " -> Status: " + scenario.getStatus());
		if (scenario.isFailed()) {
			embedScreenshot(scenario);

		}
	}
}
