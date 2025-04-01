package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name="firstname")
	private WebElement firstName;
	
	public void enterFirstName(String fNameText) {
		elementUtils.SendkeysToElement(firstName, CommonUtils.EXPLICIT_WAITTIME, fNameText);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	public void enterLastName(String lNameText) {
		elementUtils.SendkeysToElement(lastName, CommonUtils.EXPLICIT_WAITTIME, lNameText);
	}
	
	@FindBy(name="email")
	private WebElement email;
	
	public void enterEmail(String emailText) {
		elementUtils.SendkeysToElement(email, CommonUtils.EXPLICIT_WAITTIME, emailText);
	}
	
	@FindBy(name="telephone")
	private WebElement telephone;
	
	public void enterTelephone(String telephoneText) {
		elementUtils.SendkeysToElement(telephone, CommonUtils.EXPLICIT_WAITTIME, telephoneText);
	}
	
	@FindBy(name="password")
	private WebElement password;
	
	public void enterPassword(String passwordText) {
		elementUtils.SendkeysToElement(password, CommonUtils.EXPLICIT_WAITTIME, passwordText);
	}
	
	@FindBy(name="confirm")
	private WebElement confirmPassword;
	
	public void enterConfirmPassword(String confirmText) {
		elementUtils.SendkeysToElement(confirmPassword, CommonUtils.EXPLICIT_WAITTIME, confirmText);
	}
	
	@FindBy(xpath="//input[@name='newsletter'][1]")
	private WebElement yesNewsLetter;
	
	public void clickyesNewsLetter() {
		elementUtils.clickOnElement(yesNewsLetter, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(name="agree")
	private WebElement privacyPolicy;
	
	public void checkPrivacyPolicy() {
		elementUtils.clickOnElement(privacyPolicy, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	public AccountSuccessPage clickOnContinueButton() throws InterruptedException {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
		return new AccountSuccessPage(driver);
	}
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public boolean getWarningMessage() {
		return elementUtils.displayStatusOfElement(warningMessage, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstNameWarning;
	
	public boolean getfirstNameWarning() {
		return elementUtils.displayStatusOfElement(firstNameWarning, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastNameWarning;
	
	public boolean getLastNameWarning() {
		return elementUtils.displayStatusOfElement(lastNameWarning, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;
	
	public boolean getemailWarning() {
		return elementUtils.displayStatusOfElement(emailWarning, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	public boolean getTelephoneWarning() {
		return elementUtils.displayStatusOfElement(telephoneWarning, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public boolean getPasswordWarning() {
		return elementUtils.displayStatusOfElement(passwordWarning, CommonUtils.EXPLICIT_WAITTIME);
	}

}
