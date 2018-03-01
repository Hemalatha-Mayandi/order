package com.waitrose.order.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescPO extends BasePage{
	@FindBy(css = "button[class='btn-primary___rLeez btn button___KSeac btn']")
	private WebElement addToTrolleybutton;
	
	@FindBy(css = "button[id='trolleyOverview']")
	private WebElement basketIcon;
	
	public void clickAddtoTrolleybutton() {
		clickOnWebElement(addToTrolleybutton);
	}
	
	public void clickBasketIcon() {
		clickOnWebElement(basketIcon);
	}
	

}
