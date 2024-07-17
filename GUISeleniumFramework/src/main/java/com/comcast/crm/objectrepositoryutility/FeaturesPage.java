package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeaturesPage {
	WebDriver driver;

	public FeaturesPage(WebDriver driver) { // Rule 3 : Object Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add Product")
	private WebElement addproductbtn;

	@FindBy(name = "filter")
	private WebElement searchtxtfield;

	@FindBy(xpath = "//td[text()='puma']/../td[6]//a[@href='stockin.php?id=78653']")
	private WebElement pumastockinbtn;

	@FindBy(xpath = "//td[text()='Flyknit 360']/../td[6]//a[@href='stockout.php?id=358159']")
	private WebElement Flyknit360stockoutbtn;

	@FindBy(xpath = "//input[@placeholder='Enter No. of Stock']")
	private WebElement stockinnumbertextfield;

	@FindBy(xpath = "//button[contains(text(),'Save Data')]")
	private WebElement stockINsavedatabtn;

	@FindBy(xpath = "//input[@placeholder='Enter No. of Stock']")
	private WebElement stockoutnumbertextfield;

	@FindBy(xpath = "//button[contains(text(),'Save Data')]")
	private WebElement stockOutsavedatabtn;

	@FindBy(xpath = "//h2[text()='Features']")
	private WebElement featurespagetitle;

	@FindBy(xpath = "//span[text()='Stock IN']")
	private WebElement stockinpagetitle;

	@FindBy(xpath = "//span[text()='Stock OUT']")
	private WebElement stockoutpagetitle;

	public WebElement getStockoutpagetitle() {
		return stockoutpagetitle;
	}

	public WebElement getStockinpagetitle() {
		return stockinpagetitle;
	}

	public WebElement getFeaturespagetitle() {
		return featurespagetitle;
	}

	public WebElement getStockinnumbertextfield() {
		return stockinnumbertextfield;
	}

	public WebElement getStockINsavedatabtn() {
		return stockINsavedatabtn;
	}

	public WebElement getStockoutnumbertextfield() {
		return stockoutnumbertextfield;
	}

	public WebElement getStockOutsavedatabtn() {
		return stockOutsavedatabtn;
	}

	public WebElement getstockINsavedatabtn() {
		return stockINsavedatabtn;
	}

	public WebElement getstockinnumbertextfield() {
		return stockinnumbertextfield;
	}

	public WebElement getAddproductbtn() {
		return addproductbtn;
	}

	public WebElement getSearchtxtfield() {
		return searchtxtfield;
	}

	public WebElement getPumastockinbtn() {
		return pumastockinbtn;
	}

	public WebElement getFlyknit360stockoutbtn() {
		return Flyknit360stockoutbtn;
	}

}
