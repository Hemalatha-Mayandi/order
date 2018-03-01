@Hema
Feature: Waitrose Sign In 
As a new user  
In order to Sign In 
I want to Register 

Scenario Outline: Successfull Login Test 
	Given I go to Waitrose Home page 
	When I click on SignIn/Register button 
	Then I should see "Welcome, enter your details to get started." text
	And I keyin my Email Address as "<ID>" 
	And I click Continue button
	And I keyin my Password as "<PASS>" 
	And I select SignIn button 
	Then I should be navigated to the page "<Landing_Page>" 
	Examples: 
		|ID						|PASS		|		Landing_Page 	|
		|m.hemalatha@gmail.com	|Testing123	|		My Trolley		|
		#|m.hemalat@gmailcom	|			|		Please enter a valid email address.	|
		#|Test@gmail.com		|Te			|		Login Page 		|
		#|Test@gmailcom			|Te			|		Login Page		|