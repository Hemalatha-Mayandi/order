package com.waitrose.order.bdd.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductListPO extends BasePage{

	@FindBy(css = "input[id='search']")
	private WebElement searchProduct;

	@FindBy(css = "div[class='navigation-bar-search-wrapper'] button")
	private WebElement clickSearch;
	
	@FindBy(css = "div[class='searchTermTag___oRPcy']")
	private WebElement productSearched;
	
	@FindBy(css = "button[class='closeNoticeSomethingDifferentPopup']")
	private WebElement closecookies;
	
	@FindBy(css = "select[aria-label='Sort By']")
	private WebElement sortSearch;
	
	@FindBy(css = "section[class='details___2RheR'] header[class='prodDetails___2rfK1'] span[class='name___2sgmL']")
	private String selectProduct;
	
	public void enterproductsearch(String productName) {
		enterText(searchProduct,productName);
	}
	
	public void clickSearchButton() {
		clickOnWebElement(clickSearch);
	}
	
	public void assertproductSearched(String productEntered) {
		assertTextOnWebElement(productSearched,productEntered);
	}
	
	public void closeCookies(){
		clickOnWebElement(closecookies);
	}
	
	public void selectSortSearch(String sort) {
		selectFromDropDown(sortSearch,sort);
		
	}
	
	public void selectFirstProduct(){
		JavascriptExecutor je = (JavascriptExecutor) driver;
		List<WebElement> groupSelection =  wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("section[class='details___2RheR'] header[class='prodDetails___2rfK1'] span[class='name___2sgmL']")));
		je.executeScript("scroll(250,400)");
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("section[class='details___2RheR'] header[class='prodDetails___2rfK1'] span[class='name___2sgmL']"))).get(1).click();

	}
}
