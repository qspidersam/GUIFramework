package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author HP
 * 
 *         Contains home page elements
 *
 */
public class Homepage extends WebDriverUtility {

	WebDriver driver;

	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Products") // Rule-2 Object Creation
	private WebElement productlink;

	@FindBy(linkText = "Features") // Rule-2 Object Creation
	private WebElement Featureslink;

	@FindBy(linkText = "Basketball") // Rule-2 Object Creation
	private WebElement Basketballlink;

	@FindBy(linkText = "Football") // Rule-2 Object Creation
	private WebElement Footballlink;

	@FindBy(linkText = "Running")
	private WebElement Runninglink;

	@FindBy(linkText = "Transactions")
	private WebElement Transactionslink;
	
	@FindBy(xpath= "//a[text()='logout']")
	private WebElement logoutlink;
	
	

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getFeatureslink() {
		return Featureslink;
	}

	public WebElement getBasketballlink() {
		return Basketballlink;
	}

	public WebElement getFootballlink() {
		return Footballlink;

	}

	public WebElement getTransactionslink() {
		return Transactionslink;
	}

	public WebElement getRunninglink() {
		return Runninglink;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	

}
