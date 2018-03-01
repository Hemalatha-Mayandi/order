package com.waitrose.order.bdd.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPO extends BasePage {
	@FindBy(css = "div[id='content'] header h1")
	private WebElement headerLabel;

	@FindBy(css = "input[id='logon-email']")
	private WebElement emailIdTextField;

	@FindBy(css = "input[class='button primary-cta button-continue']")
	private WebElement continueButton;

	@FindBy(css = "input[id='logon-password']")
	private WebElement passwordTextField;

	@FindBy(css = "input[id='logon-button-sign-in']")
	private WebElement signInButton;

	@FindBy(css = "div[class='trolley-top'] p")
	private WebElement registeredUserLabel;

	public void assertHeaderLabel(String labelText) {
		assertTextOnWebElement(headerLabel, labelText);
	}

	public void enterEmailId(String email) {
		enterText(emailIdTextField, email);
	}

	public void clickOnContinueButton() {
		clickOnWebElement(continueButton);
	}

	public void enterPassword(String password) {
		enterText(passwordTextField, password);
	}

	public void clickOnsignInButton() {
		clickOnWebElement(signInButton);
	}

	public void assertregisteredUserLabel(String label) {
		assertTextOnWebElement(registeredUserLabel, label);
	}
}
