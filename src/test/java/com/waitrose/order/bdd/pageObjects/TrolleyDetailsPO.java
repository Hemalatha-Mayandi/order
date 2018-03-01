package com.waitrose.order.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrolleyDetailsPO extends BasePage{

	@FindBy(css = "a[id='fullTrolley']")
	private WebElement trolleyDetailsButton;
	
	@FindBy(css = "div[class='sticky-outer-wrapper'] button[id='site-header-checkout']")
	private WebElement checkOutButton;
	
	@FindBy(css = "button[class='btn-plain-text___fWj0V btn emptyTrolleyButton___29x0_']")
	private WebElement emptyButton;
	
	@FindBy(css = "button[class='btn-primary___rLeez btn emptyTrolleyModalButton___3-WMZ']")
	private WebElement confirmEmptyBasket;
	
	@FindBy(css = "header[class='header___1GXfm horizontalSpacing___1Juch']")
	private WebElement itemInEmptyBasket;
	
	public void assertbasketTrolleyDetails(String trolleyDetails) {
		assertTextOnWebElement(trolleyDetailsButton,trolleyDetails);
	}
	
	public void clickTrolleyDetails() {
		clickOnWebElement(trolleyDetailsButton);
	}
	
	public void clickCheckOut() {
		clickOnWebElement(checkOutButton);
	}
	
	public void clickEmptyButton() {
		clickOnWebElement(emptyButton);
	}
	
	public void clickConfirmEmptyBasket() {
		clickOnWebElement(confirmEmptyBasket);
	}
	
	public void assertItemInEmptyBasket(String emptyBasket) {
		assertTextOnWebElement(itemInEmptyBasket,emptyBasket);
	}
}
