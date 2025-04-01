package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name="email")
	private WebElement email;
	
	public void enterEmail(String emailText) {
		elementUtils.SendkeysToElement(email, CommonUtils.EXPLICIT_WAITTIME, emailText);
	}
	
	@FindBy(name="password")
	private WebElement password;
	
	public void enterPassword(String passwordText) {
		elementUtils.SendkeysToElement(password, CommonUtils.EXPLICIT_WAITTIME, passwordText);
	}
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	public AccountInfoPage clickLoginButton() throws InterruptedException {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
		return new AccountInfoPage(driver);
	}

}
