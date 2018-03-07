package com.waitrose.order.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrolleyDetailsPO extends BasePage{

	@FindBy(css = "a[id='fullTrolley']")
	private WebElement trolleyDetailsButton;
	
	@FindBy(css = "div[class='sticky-outer-wrapper'] button[id='site-header-checkout']")
	private WebElement checkOutButton;
	
	@FindBy(css = "button[class*='emptyTrolleyButton']")
	private WebElement emptyButton;
	
	@FindBy(css = "button[class='btn-primary___rLeez btn emptyTrolleyModalButton___3-WMZ']")
	private WebElement confirmEmptyBasket;
	
	@FindBy(css = "header[class='header___1GXfm horizontalSpacing___1Juch']")
	private WebElement itemInEmptyBasket;
	
	@FindBy(partialLinkText = "Sign out")
	private WebElement signOut;
	
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
	
	public void clickSignOut() {
		clickOnWebElement(signOut);
	}
}
