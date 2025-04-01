package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement  myAccountDropMenu;
	
	public void clickOnMyAccount() throws InterruptedException {
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
	}
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	public RegisterPage clickOnRegister() throws InterruptedException {
		elementUtils.clickOnElement(RegisterOption, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
		return new RegisterPage(driver);
	}
	
	@FindBy(linkText="Login")
	private WebElement LoginOption;
	
	public LoginPage clickOnLogin() throws InterruptedException {
		elementUtils.clickOnElement(LoginOption, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
		return new LoginPage(driver);
	}
	
	@FindBy(name="search")
	private WebElement searchBox;
	
	public void enterSearchBox(String searchBoxText) {
		elementUtils.SendkeysToElement(searchBox, CommonUtils.EXPLICIT_WAITTIME, searchBoxText);
	}
	
	@FindBy(xpath="//div[@id='search']//i")
	private WebElement searchIcon;
	
	public SearchResultsPage clicksearchIcon() throws InterruptedException {
		elementUtils.clickOnElement(searchIcon, CommonUtils.EXPLICIT_WAITTIME);
		Thread.sleep(5000);
		return new SearchResultsPage(driver);
	}
	

}
