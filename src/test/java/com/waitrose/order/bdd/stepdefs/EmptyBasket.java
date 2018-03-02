package com.waitrose.order.bdd.stepdefs;

import org.openqa.selenium.support.PageFactory;

import com.waitrose.order.bdd.pageObjects.TrolleyDetailsPO;
import com.waitrose.order.bdd.utils.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class EmptyBasket {
	
	TrolleyDetailsPO trolleyDetailsPO = PageFactory.initElements(WebConnector.driver, TrolleyDetailsPO.class);
	
	@And("^I click Empty Trolley link$")
	public void i_click_Empty_Trolley_link() {
		trolleyDetailsPO.clickEmptyButton();
	}

	@And("^I click Confirm to Empty Trolley$")
	public void i_click_Confirm_to_Empty_Trolley() {
		trolleyDetailsPO.clickConfirmEmptyBasket();
	}
	
	@Then("^I should see Basket with \"([^\"]*)\"$")
	public void i_should_see_Basket_with(String emptyBasket) {
		trolleyDetailsPO.assertItemInEmptyBasket(emptyBasket);
	   
	}

}
