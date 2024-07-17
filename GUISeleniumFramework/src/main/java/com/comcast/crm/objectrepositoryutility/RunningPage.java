package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RunningPage {
	
	WebDriver driver;
	 public RunningPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	                           
	@FindBy(linkText ="Add Product")                       
	private WebElement addproductbtn;
	
	@FindBy(name="filter")                       
	private WebElement searchtxtfield;
	
	@FindBy(partialLinkText ="Stock In")                       
	private WebElement  StockInbtn;
	
	@FindBy(partialLinkText ="Stock Out")                       
	private WebElement  Stockoutbtn;
	
	
	public WebElement getAddproductbtn() {
		return addproductbtn;
	}

	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}

	public WebElement getStockInbtn() {
		return StockInbtn;
	}

	public WebElement getStockoutbtn() {
		return Stockoutbtn;
	}


}
