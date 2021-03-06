package com.waitrose.order.bdd.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.waitrose.order.bdd.utils.WebConnector;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class BasePage extends WebConnector {

	public WebDriverWait wait = new WebDriverWait(WebConnector.driver, 60);
	
	public String URL = "https://www.waitrose.com/";
	
	public void navigateToHomePage() {
    	driver.get(URL);
    }

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Waiting functionality
	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Allows selenium to pause for a set amount of time
	 *
	 * @param seconds
	 *            time to wait in seconds
	 */
	public void timeUnitWait(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			return;
		}
	}

	public WebElement waitForElementClickable(WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public WebElement waitForVisibilityOfElement(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	public WebElement waitForPresenceOfElement(String cssSelector) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////
	// Selenium actions functionality
	// /////////////////////////////////////////////////////////////////////////////////////////////////

	public void enterText(WebElement element, String text) {
		waitForVisibilityOfElement(element);
		element.clear();
		element.sendKeys(text);
	}

	public void clickOnWebElement(WebElement element) {
		try {
			waitForElementClickable(element).click();
		} catch (WebDriverException e) {
			throw new RuntimeException("Element not found on the page", e);
		}
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public void switchToActiveElement() {
		driver.switchTo().activeElement();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public Boolean isElementDisplayed(String expression) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(expression)));
		WebElement element = driver.findElement(By.cssSelector(expression));
		return element.isDisplayed();
	}

	/**
	 * Asserts WebElement is displayed
	 *
	 * @param expression
	 *            String used inside css selector
	 */
	public void assertWebElementPresence(String expression) {
		assertThat(isElementDisplayed(expression), is(true));
	}

	/**
	 * Asserts expected and actual text in web page
	 *
	 * @param element
	 *            String element
	 * @param expectedText
	 *            String text
	 */
	public void assertTextOnWebElement(WebElement element, String expectedText) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getText();
		assertThat(actualText, containsString(expectedText));
	}
	
	public void assertvalueOnWebElement(WebElement element, String expectedText) {
		wait.until(ExpectedConditions.visibilityOf(element));
		String actualText = element.getAttribute("value");
		assertThat(actualText, containsString(expectedText));
	}

	public void selectFromDropDown(WebElement element, String keyword) {
		Select dropDownOption = new Select(element);
		dropDownOption.selectByValue(keyword);
	}
	
	public void waitForVisibilityOfElementList(String cssSelector,int itemNo) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		List<WebElement> element = wait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector)));
		je.executeScript("scroll(250,400)");
		wait
		.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(cssSelector))).get(itemNo).click();
	}
}
