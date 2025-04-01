package stepdefinitions;

import java.util.Date;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountInfoPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountInfoPage accountInfoPage;
	private RegisterPage registerPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() throws InterruptedException {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		loginPage = homePage.clickOnLogin();
	}

	@When("User enteres valid email address {string} into email field")
	public void user_enteres_valid_email_address_into_email_field(String string) {
		loginPage.enterEmail(string);
	}

	@When("User enteres valid password {string} into password field")
	public void user_enteres_valid_password_into_password_field(String string) {
		loginPage.enterPassword(string);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		accountInfoPage = loginPage.clickLoginButton();
	}

	@Then("User successfully logged into account")
	public void user_successfully_logged_into_account() {
	    Assert.assertTrue(accountInfoPage.verifyEditYourInformationIsAvailable());
	}
	
	@When("User enteres invalid email address into email field with timestamp")
	public void user_enteres_invalid_email_address_into_email_field_with_timestamp() {
		commonUtils = new CommonUtils();
		loginPage.enterEmail(commonUtils.getEmailWithTimestamp());
	}

	@When("User enteres invalid password {string} into password field")
	public void user_enteres_invalid_password_into_password_field(String string) {
		loginPage.enterPassword(string);
	}
	
	@When("User should get a proper warning about no match about email")
	public void User_should_get_a_proper_warning_about_no_match_about_email() {
		registerPage = new RegisterPage(driver);
		registerPage.getWarningMessage();
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
	    
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
	}
	
}
