Feature: Search functionality

Scenario: searches a valid product
Given User opens the application
When User enter valid product "hp" into search field
And clicks on search icon
Then User gets valid product displayed on search results

Scenario: searches a invalid product
Given User opens the application
When User enter invalid product "honda" into search field
And clicks on search icon
Then User gets a proper warning about no product matching

Scenario: searches dont enter any details
Given User opens the application
When User dont enter product name into search field
And clicks on search icon
Then User gets a proper warning about no product matching