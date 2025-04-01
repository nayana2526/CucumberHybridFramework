Feature: Login functionality

Scenario: Login with valid credentials
Given User navigates to login page
When User enteres valid email address "vanam.ajay@gmail.com" into email field
And User enteres valid password "V@nam2526" into password field
And User clicks on login button
Then User successfully logged into account

Scenario: Login with invalid credentials
Given User navigates to login page
When User enteres invalid email address into email field with timestamp
And User enteres invalid password "V@nam25262526" into password field
And User clicks on login button
Then User should get a proper warning about no match about email

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enteres valid email address "vanam.ajay@gmail.com" into email field
And User enteres invalid password "V@nam25262526" into password field
And User clicks on login button
Then User should get a proper warning about no match about email

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enteres invalid email address into email field with timestamp
And User enteres valid password "V@nam2526" into password field
And User clicks on login button
Then User should get a proper warning about no match about email

Scenario: Login with dont provide any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get a proper warning about no match about email

