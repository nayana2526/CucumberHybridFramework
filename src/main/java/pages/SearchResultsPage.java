package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement warningNoProductMatching;
	
	public boolean verifyWarningNoProductMatching() {
		return elementUtils.displayStatusOfElement(warningNoProductMatching, CommonUtils.EXPLICIT_WAITTIME);
	}
	
	@FindBy(partialLinkText="HP LP3065")
	private WebElement displayStatusOfProduct;
	
	public boolean verifyDisplayStatusOfProduct() {
		return elementUtils.displayStatusOfElement(displayStatusOfProduct, CommonUtils.EXPLICIT_WAITTIME);
	}

}
