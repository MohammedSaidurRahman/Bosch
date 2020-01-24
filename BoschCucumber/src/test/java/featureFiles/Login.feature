Feature: Log into account
	After loading the shopping site the user should sign in using correct credentials
	
Scenario: Log into account using correct credentials
	Given Shopping site is loaded
	And User clicks on sign in button on home page
	And User enters a valid email address
	And User enters a valid password
	When User clicks on sign in button 
	Then User should be successfully signed in  