package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class AdminLoginPage extends WebDriverUtility {
	
	WebDriver driver;
	 public AdminLoginPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	                           
	@FindBy(name="username")                        // Rule-2 Object Creation
	private WebElement usernameEdit;
	
	@FindBy(name="password")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//input[@value='Enter']")
	private WebElement enterbutton;
	
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getEnterbutton() {
		return enterbutton;
	}
	

	
	/*
	 * businessmethod
	 */
	public void loginToAdmin(String url,String username,String password) {
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		enterbutton.click();
		
	}
	
	
	
}
