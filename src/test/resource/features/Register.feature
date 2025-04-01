Feature: Register functionality

Scenario: Register with only mandatory fields
Given User navigates to register page
When User enters the details into below fields
|	firstname		|  	ajayV										|
|	lastname		| 	vanam										|
|	telephone		| 	1234567890 							|
| password 		| 	V@1234567890 							|
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: Register with all fields
Given User navigates to register page
When User enters the details into below fields
|	firstname		|  	ajayVV										|
|	lastname		| 	vanam										|
|	telephone		| 	1234567890 							|
| password 		| 	V@nam2526 							|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: Register with duplicate account
Given User navigates to register page
When User enters the details into below fields with duplicate email
|	firstname		|  	ajayVV										|
|	lastname		| 	vanam										|
|	email 			|  	ajay.vanam@gmail.com|
|	telephone		| 	1234567890 							|
| password 		| 	V@nam2526 							|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper waring message about duplicate email

Scenario: Register with dont provide details
Given User navigates to register page
When User dont enter any details into fields
And User clicks on continue button
Then User should get a proper waring message about every mandatory field