package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountInfoPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public AccountInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
    
	@FindBy(linkText="Edit your account information")
	private WebElement editYourInformationIsAvailable;
	
	public boolean verifyEditYourInformationIsAvailable() {
		return elementUtils.displayStatusOfElement(editYourInformationIsAvailable, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	
}
