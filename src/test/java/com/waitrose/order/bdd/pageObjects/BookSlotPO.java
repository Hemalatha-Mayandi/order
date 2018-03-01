package com.waitrose.order.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookSlotPO extends BasePage{
	@FindBy(css = "a[class='serviceSelectorCollection___2B9Un']")
	private WebElement clickAndCollecticon;
	
	@FindBy(css = "input[id='newAddressPostcodeInput']")
	private WebElement postCode;
	
	@FindBy(css = "div[class='addressContainer___3tSPg'] div :nth-child(1)")
	private String firstAddress;
	
	@FindBy(css = "button[id='slot2']")
	private WebElement firstSlot;
	
	@FindBy(css = "div[class='confirmationMessage___aP4BL'] h2")
	private WebElement slotReserved;
	
	public void clickClickAndCollection() {
		clickOnWebElement(clickAndCollecticon);
	}
	
	public void assertPostCode(String myPostcode) {
		assertvalueOnWebElement(postCode,myPostcode);
		clickOnWebElement(postCode);
	}
		
	public void clickFirstAddressOption() {
		//waitForVisibilityOfElementList(firstAddress,firstOption);
		
		List<WebElement> firstOption =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='addressContainer___3tSPg'] div :nth-child(1)")));
		firstOption.get(1).click();
	}
	public void clickFirstSlot() {
		clickOnWebElement(firstSlot);
	}
	
	public void assertSlotReservation(String slotreservationMessage) {
		assertTextOnWebElement(slotReserved,slotreservationMessage);
	}
	
}
