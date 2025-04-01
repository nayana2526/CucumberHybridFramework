package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private HomePage home;
	private CommonUtils commonUtils;
	
	@Given("User navigates to register page")
	public void user_navigates_to_register_page() throws InterruptedException {
		driver = DriverFactory.getDriver();
		home = new HomePage(driver);
	    home.clickOnMyAccount();
	    registerPage = home.clickOnRegister();
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		 Map<String, String> map = dataTable.asMap(String.class, String.class);
		 registerPage.enterFirstName(map.get("firstname"));
		 registerPage.enterLastName(map.get("lastname"));
		 commonUtils = new CommonUtils();
		 registerPage.enterEmail(commonUtils.getEmailWithTimestamp());
		 registerPage.enterTelephone(map.get("telephone"));
		 registerPage.enterPassword(map.get("password"));
		 registerPage.enterConfirmPassword(map.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		 Map<String, String> map = dataTable.asMap(String.class, String.class);
		 registerPage.enterFirstName(map.get("firstname"));
		 registerPage.enterLastName(map.get("lastname"));
		 registerPage.enterEmail(map.get("email"));
		 registerPage.enterTelephone(map.get("telephone"));
		 registerPage.enterPassword(map.get("password"));
		 registerPage.enterConfirmPassword(map.get("password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		registerPage.checkPrivacyPolicy();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	    Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getAccountSuccessMessage());
	}

	@When("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		registerPage.clickyesNewsLetter();
	}

	@Then("User should get a proper waring message about duplicate email")
	public void user_should_get_a_proper_waring_message_about_duplicate_email() {
		Assert.assertTrue(registerPage.getWarningMessage());
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	    
	}

	@Then("User should get a proper waring message about every mandatory field")
	public void user_should_get_a_proper_waring_message_about_every_mandatory_field() {
		Assert.assertTrue(registerPage.getWarningMessage());
		Assert.assertTrue(registerPage.getfirstNameWarning());
		Assert.assertTrue(registerPage.getLastNameWarning());
		Assert.assertTrue(registerPage.getemailWarning());
		Assert.assertTrue(registerPage.getTelephoneWarning());
		Assert.assertTrue(registerPage.getPasswordWarning());
	}

}
