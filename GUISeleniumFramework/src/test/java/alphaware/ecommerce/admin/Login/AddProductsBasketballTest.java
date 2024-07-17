package alphaware.ecommerce.admin.Login;

import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.BasketballPage;
import com.comcast.crm.objectrepositoryutility.Homepage;

/**
 * 
 * @author supriya
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddProductsBasketballTest extends AdminBaseClass {
	/**
	 * Test script for AddProductsBasketball
	 * @throws Throwable
	 */

	@Test
	public void addproductsbasketball() throws Throwable {
		
	/*fetching expectedBasketballpagetitle and  expectedAddproductpagetitle data from excel for verification  */

		String expectedBasketballpagetitle = eLib.getDataFromExcel("alpha", 7, 5);

		String expectedAddproductpagetitle = eLib.getDataFromExcel("alpha", 7, 6);
		/*creating object of homepage and clicking on basketball page*/

		Homepage hp = new Homepage(driver);
		wlib.mousemoveOnElement(driver, hp.getProductlink());
		hp.getBasketballlink().click();
		BasketballPage bbp = new BasketballPage(driver);
		
		/*fetching the title of basketball page*/

		String actBasketballpagetitle = bbp.getBasketballpagetitle().getText();

		Assert.assertEquals(expectedBasketballpagetitle, actBasketballpagetitle);
		Reporter.log(actBasketballpagetitle + "  basketballpage is displaying", true);
		
		/*clicking on addproductbtn fetch the title of add product page */

		bbp.getAddproductbtn().click();
		wlib.waitForElementPresent(driver, bbp.getINBasketballAddproductpagetitle());

		String actAddproductpagetitle = bbp.getINBasketballAddproductpagetitle().getText();
		

		Assert.assertEquals(expectedAddproductpagetitle, actAddproductpagetitle);
		Reporter.log(actAddproductpagetitle + " add product page is displaying", true);
		/*providing the data from excel in add product page*/

		wlib.waitForElementPresent(driver, bbp.getProductnametextfield());

		String productName = eLib.getDataFromExcel("alpha", 7, 0) + jLib.getRandomNumber();
		bbp.getProductnametextfield().sendKeys(productName);

		String price = eLib.getDataFromExcel("alpha", 7, 1);
		bbp.getProductpricetextfield().sendKeys(price);

		String size = eLib.getDataFromExcel("alpha", 7, 2);
		bbp.getProductsizetextfield().sendKeys(size);

		String BrandName = eLib.getDataFromExcel("alpha", 7, 3);
		bbp.getBrandtextfield().sendKeys(BrandName);

		String Noofstock = eLib.getDataFromExcel("alpha", 7, 4);
		bbp.getQtytextfield().sendKeys(Noofstock);

		bbp.getChoosefilebtn().sendKeys("C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot (21).png");

		bbp.getAddbtn().click();
		/* fetching the product info*/

		String productinfo = driver
				.findElement(By.xpath("//th[text()='Product Name']/../../..//td[text()='" + productName + "']"))
				.getText();

		Assert.assertEquals(productinfo, productName);
		UtilityClassObject.getTest().log(Status.PASS, "product added sucessfully");

		Reporter.log(productinfo + "  product added", true);
	}

}
