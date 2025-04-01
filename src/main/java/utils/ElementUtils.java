package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
	WebDriver driver;
	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		}
	
	
	public WebElement waitForElementToBeClickable(WebElement element,long durationInSeconds) {
		WebElement webElement = null;;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert = wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public WebElement waitForElementVisiblilityOf(WebElement element,long durationInSeconds) {
		WebElement webElement = null;;
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement = wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	
	public void clickOnElement(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
		webElement.click();
	}
	
	public void SendkeysToElement(WebElement element,long durationInSeconds,String sendkeysText) {
		WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(sendkeysText);
	}
	
	public void dropdownSelectionWithVisibleText(WebElement element,long durationInSeconds,String dropdownOption) {
		WebElement webElement = waitForElementToBeClickable(element,durationInSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(dropdownOption);
	}
	
	public void acceptAlert(WebElement element,long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.accept();
	}
	
	public void dismissAlert(WebElement element,long durationInSeconds) {
		Alert alert = waitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	public void MouseHoverAndClick(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElementVisiblilityOf(element,durationInSeconds);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}
	
	public void javascriptClick(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElementVisiblilityOf(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
	}
	
	public void javascriptSendkeys(WebElement element,long durationInSeconds,String sendkeysText) {
		WebElement webElement = waitForElementVisiblilityOf(element,durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+sendkeysText+"'", webElement);
	}
	
	public String getTextFromElement(WebElement element,long durationInSeconds) {
		WebElement webElement = waitForElementVisiblilityOf(element,durationInSeconds);
		return webElement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {
		try {
			WebElement webElement = waitForElementVisiblilityOf(element,durationInSeconds);
			return webElement.isDisplayed();
		}catch(Throwable e) {
			return false;
		}
	}
}
