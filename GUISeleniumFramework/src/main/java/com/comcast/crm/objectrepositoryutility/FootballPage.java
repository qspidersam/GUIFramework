package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootballPage {
	WebDriver driver;
	 public FootballPage(WebDriver driver) {             //Rule 3 : Object Initialization
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	                           
	@FindBy(linkText ="Add Product")                       
	private WebElement addproductbtn;
	
	@FindBy(name="filter")                       
	private WebElement searchtxtfield;
	
	@FindBy(name="product_name")                       
	private WebElement productnametextfield;
	
	
	@FindBy(name="product_price")                       
	private WebElement productpricetextfield;
	
	@FindBy(name="product_size")                       
	private WebElement productsizetextfield;
	
	@FindBy(name="brand")                       
	private WebElement brandtextfield;
	
	@FindBy(name="qty")                       
	private WebElement qtytextfield;
	
	@FindBy(xpath="//input[@type='submit']")                       
	private WebElement addbtn;
	
	@FindBy(name="product_image")                       
	private WebElement choosefilebtn;
	
	@FindBy(xpath="//h2[text()='Football']")                       
	private WebElement footballtitlepage;
	
	@FindBy(xpath="//h3[text()='Add Product...']")                        
	private WebElement INFootballAddproductpagetitle;
	
	public WebElement getINFootballAddproductpagetitle() {
		return INFootballAddproductpagetitle;
	}
	
	
	
	
	
	
	
		public WebElement getFootballtitlepage() {
		return footballtitlepage;
	}

		public WebElement getProductnametextfield() {
		return productnametextfield;
	}

	public WebElement getProductpricetextfield() {
		return productpricetextfield;
	}

	public WebElement getProductsizetextfield() {
		return productsizetextfield;
	}

	public WebElement getBrandtextfield() {
		return brandtextfield;
	}

	public WebElement getQtytextfield() {
		return qtytextfield;
	}

	public WebElement getAddbtn() {
		return addbtn;
	}

	public WebElement getChoosefilebtn() {
		return choosefilebtn;
	}

		public WebElement getAddproductbtn() {
		return addproductbtn;
	}

	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}

	

}
