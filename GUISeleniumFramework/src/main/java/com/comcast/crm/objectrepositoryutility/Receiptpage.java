package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Receiptpage {
	
	WebDriver driver;

	public Receiptpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		
		
		@FindBy(xpath="//label[text()='Official Receipt']")
		private WebElement receiptpagetitle;

		public WebElement getReceiptpagetitle() {
			return receiptpagetitle;
		}
		
	
	
	

}
