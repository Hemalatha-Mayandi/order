package com.waitrose.order.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePagePO extends BasePage {

	@FindBy(css = "button[class='button primary-cta js-sign-in-register']")
	private WebElement signInLink;

	public void clickOnSignInLink() {
		clickOnWebElement(signInLink);
	}
}
