package com.waitrose.order.bdd.stepdefs;

import org.openqa.selenium.support.PageFactory;

import com.waitrose.order.bdd.pageObjects.BookSlotPO;
import com.waitrose.order.bdd.pageObjects.HomePagePO;
import com.waitrose.order.bdd.pageObjects.ProductDescPO;
import com.waitrose.order.bdd.pageObjects.ProductListPO;
import com.waitrose.order.bdd.pageObjects.SignInPO;
import com.waitrose.order.bdd.pageObjects.TrolleyDetailsPO;
import com.waitrose.order.bdd.utils.WebConnector;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckOut {
		
	HomePagePO homePagePO = PageFactory.initElements(WebConnector.driver, HomePagePO.class);

	SignInPO SignInPO = PageFactory.initElements(WebConnector.driver, SignInPO.class);
	
	ProductListPO ProductListPO = PageFactory.initElements(WebConnector.driver, ProductListPO.class);
	
	ProductDescPO ProductDescPO = PageFactory.initElements(WebConnector.driver, ProductDescPO.class);
	
	TrolleyDetailsPO trolleyDetailsPO = PageFactory.initElements(WebConnector.driver, TrolleyDetailsPO.class);
	
	BookSlotPO BookSlotPO= PageFactory.initElements(WebConnector.driver, BookSlotPO.class);
	
	@Given("^I navigate to Waitrose Home Page$")
	public void i_navigate_to_Waitrose_Home_Page() {
		homePagePO.navigateToHomePage();
	}

	@When("^I clicked on SignIn/Register button$")
	public void i_clicked_on_SignIn_Register_button()  {
		homePagePO.clickOnSignInLink();
	}

	@Then("^I should see \"([^\\\"]*)\" text$")
	public void i_should_see_text(String label) {
		SignInPO.assertHeaderLabel(label);
	}
	 
	@And("^I entered my Email Address as \"([^\"]*)\"$")
	public void i_entered_my_Email_Address_as(String email)  {
		SignInPO.enterEmailId(email);
	  
	}
	
	@And("^I clicked Continue button$")
	public void i_click_Continue_button()  {
		SignInPO.clickOnContinueButton();
	  
	} 
	@And("^I entered my Password \"([^\"]*)\"$")
	public void i_entered_my_Password(String password)  {
		SignInPO.enterPassword(password);
	}

	@And("^I selected SignIn button$")
	public void i_selected_SignIn_button()  {
		SignInPO.clickOnsignInButton();
	}

	@Then("^I should be navigated to \"([^\"]*)\"$")
	public void i_should_be_navigated_to_the_page(String registereduser)  {
		SignInPO.assertregisteredUserLabel(registereduser);
	}
	
	@And("^I enter \"([^\"]*)\" to search$")
	public void i_enter_to_search(String product) {
	    	ProductListPO.enterproductsearch(product);
	}

	@And("^I click search button$")
	public void i_click_search_button() {
		ProductListPO.clickSearchButton();
	   
	}
	
	@Then("^I should see the \"([^\"]*)\"$")
	public void i_should_see_the(String productEntered) {
		ProductListPO.assertproductSearched(productEntered);
		ProductListPO.closeCookies(); 
	}

	@And("^sort items listed by \"([^\"]*)\"$")
	public void sort_items_listed_by(String sortOption) {
	   	ProductListPO.selectSortSearch(sortOption);
	   	
	}

	@And("^I select the first product$")
	public void i_select_the_first_product() {
		ProductListPO.selectFirstProduct();
			   
	}

	@And("^I click Add to Trolley button$")
	public void i_click_Add_to_Trolley_button() {
		ProductDescPO.clickAddtoTrolleybutton();
	   
	}

	@And("^I click basket$")
	public void i_click_basket() {
		ProductDescPO.clickBasketIcon();	   
	}
		
	@And("^I should view \"([^\"]*)\"$")
	public void i_should_view(String trolleyDetails) {
		trolleyDetailsPO.assertbasketTrolleyDetails(trolleyDetails);	   
	}
	
	@And("^I click Trolley details button$")
	public void i_click_Trolley_details_button() {
		trolleyDetailsPO.clickTrolleyDetails();	   
	}
	
	@Then("^I click on Check Out button$")
	public void i_click_on_Check_Out_button() {
	    trolleyDetailsPO.clickCheckOut();
	}

	@Then("^I select Click & Collect$")
	public void i_select_Click_Collect() {
		BookSlotPO.clickClickAndCollection();
	}

	@Then("^I should see \"([^\"]*)\" post code$")
	public void i_should_see_post_code(String myPostcode) {
		BookSlotPO.assertPostCode(myPostcode);
	   
	}
	
	@And("^I select the first Address_option$")
	public void i_select_the_first_Address_option() {
		BookSlotPO.clickFirstAddressOption();
	   
	}

	@Then("^I select the first slot$")
	public void i_select_the_first_slot() {
		BookSlotPO.clickFirstSlot();
	   
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String slotreservationMessage) {
	    
		BookSlotPO.assertSlotReservation(slotreservationMessage);
		//Empty Basket
		ProductDescPO.clickBasketIcon();
		trolleyDetailsPO.clickTrolleyDetails();	 
		trolleyDetailsPO.clickEmptyButton();
		trolleyDetailsPO.clickConfirmEmptyBasket();
		trolleyDetailsPO.clickSignOut();
		
	}
	
}



