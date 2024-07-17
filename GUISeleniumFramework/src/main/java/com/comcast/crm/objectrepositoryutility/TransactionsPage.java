package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage {
	
	WebDriver driver;
	 public TransactionsPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath="//td[text()='6839']/../td[6]//a[text()='Confirm']")
	 private WebElement ID6839confirmbtn;
	 
	 @FindBy(xpath="//td[text()='8149']/../td[6]//a[@href=\"cancel.php?id=8149\"]")
	 private WebElement ID8149cancelbtn;
	 
	 @FindBy(xpath="//td[text()='66']/../td[6]//a[text()='View']")
	 private WebElement ID66viewbtn;
	 
	 @FindBy(xpath="//h2[contains(text(),'Transactions')]")
	 private WebElement transcactionspagetitle;
	 
	
	 
	

	public WebElement getID6839confirmbtn() {
		return ID6839confirmbtn;
	}

	public WebElement getID8149cancelbtn() {
		return ID8149cancelbtn;
	}

	public WebElement getID66viewbtn() {
		return ID66viewbtn;
	}

	public WebElement getTranscactionspagetitle() {
		return transcactionspagetitle;
	}
	 
	 
	 
	 
	 
	 
	 

}
