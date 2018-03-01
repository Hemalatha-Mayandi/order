@H
Feature: Waitrose empty Basket
As a registered User
I Order Online And Empty Basket

Scenario Outline: Empty Basket
	Given I navigate to Waitrose Home Page
	When I clicked on SignIn/Register button
	Then I should see "Welcome, enter your details to get started." text
	And I entered my Email Address as "<MailID>"
	And I clicked Continue button
	And I entered my Password "<Password>"
	And I selected SignIn button
	Then I should be navigated to "<Landing_Page>" 
	And I enter "<Product>" to search
	And I click search button
	Then I should see the "<Product_searched>"
	And  sort items listed by "<Sort_search>"
	And I select the first product
	And I click Add to Trolley button
	And I click basket
	Then I should view "Trolley details" 
	And I click Trolley details button
	And I click Empty Trolley link
	And I click Confirm to Empty Trolley
	Then I should see "0 trolley items"
	
	Examples: 
		|MailID					|Password		| Landing_Page 	|Product	|Product_searched|Sort_search		|
		|m.hemalatha@gmail.com	|Testing1234	| My Trolley 	|Whisky		|Whisky			 |PRICE_HIGH_2_LOW 	|