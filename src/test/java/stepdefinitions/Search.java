package stepdefinitions;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultsPage searchResultsPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
	   driver = DriverFactory.getDriver();
	   homePage = new HomePage(driver);
	}

	@When("User enter valid product {string} into search field")
	public void user_enter_valid_product_into_search_field(String string) {
		homePage.enterSearchBox(string);
	}

	@When("clicks on search icon")
	public void clicks_on_search_icon() throws InterruptedException {
		searchResultsPage = homePage.clicksearchIcon();
	}

	@Then("User gets valid product displayed on search results")
	public void user_gets_valid_product_displayed_on_search_results() {
		searchResultsPage.verifyDisplayStatusOfProduct();
	}

	@When("User enter invalid product {string} into search field")
	public void user_enter_invalid_product_into_search_field(String string) {
		homePage.enterSearchBox(string);
	}

	@Then("User gets a proper warning about no product matching")
	public void user_gets_a_proper_warning_about_no_product_matching() {
		searchResultsPage.verifyWarningNoProductMatching();
	}

	@When("User dont enter product name into search field")
	public void user_dont_enter_product_name_into_search_field() {
	    
	}

}
