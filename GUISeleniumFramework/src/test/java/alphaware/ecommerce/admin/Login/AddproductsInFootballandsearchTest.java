package alphaware.ecommerce.admin.Login;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.BasketballPage;
import com.comcast.crm.objectrepositoryutility.FootballPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
/**
 * 
 * @author supriya
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class AddproductsInFootballandsearchTest extends AdminBaseClass {
	
	/**
	 * Test script for  AddproductsInFootballandsearch
	 * @throws Throwable
	 */
	@Test
	public void addproductsInFootballandsearch() throws Throwable {
		/*fetching expectedFootballtitlepage and  expectedAddproductpagetitle data from excel for verification  */
		String expectedFootballtitlepage = eLib.getDataFromExcel("alpha", 11, 5);
		System.out.println(expectedFootballtitlepage);
		String expectedAddproductpagetitle = eLib.getDataFromExcel("alpha", 11, 6);
		System.out.println(expectedAddproductpagetitle);
		
		/*creating object of homepage and clicking on Footballlink */
		 

		Homepage hp = new Homepage(driver);
		wlib.mousemoveOnElement(driver, hp.getProductlink());
		hp.getFootballlink().click();
		
		/* creating object of football and click on add product btn*/

		FootballPage fbp = new FootballPage(driver);

		String actFootballtitlepage = fbp.getFootballtitlepage().getText();
		Assert.assertEquals(expectedFootballtitlepage, actFootballtitlepage);
		Reporter.log(actFootballtitlepage + "  footballpage is displaying", true);

		fbp.getAddproductbtn().click();
		
		/*fetching the title of add product btn*/

		wlib.waitForElementPresent(driver, fbp.getINFootballAddproductpagetitle());
		String actAddproductpagetitle = fbp.getINFootballAddproductpagetitle().getText();
		System.out.println(actAddproductpagetitle);
		Assert.assertEquals(expectedAddproductpagetitle, actAddproductpagetitle);
		Reporter.log(actAddproductpagetitle + "  Addproductpage is displaying", true);
		/* providing the data  from excel in add product page */

		String productName = eLib.getDataFromExcel("alpha", 11, 0) + jLib.getRandomNumber();
		fbp.getProductnametextfield().sendKeys(productName);

		String price = eLib.getDataFromExcel("alpha", 11, 1);
		fbp.getProductpricetextfield().sendKeys(price);

		String size = eLib.getDataFromExcel("alpha", 11, 2);
		fbp.getProductsizetextfield().sendKeys(size);

		String BrandName = eLib.getDataFromExcel("alpha", 11, 3);
		fbp.getBrandtextfield().sendKeys(BrandName);

		String Noofstock = eLib.getDataFromExcel("alpha", 11, 4);
		fbp.getQtytextfield().sendKeys(Noofstock);

		fbp.getChoosefilebtn().sendKeys("C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot (22).png");

		fbp.getAddbtn().click();
		
		/* capturing the product info */

		String productinfo = driver
				.findElement(By.xpath("//th[text()='Product Name']/../../..//td[text()='" + productName + "']"))
				.getText();
		Assert.assertEquals(productinfo, productName);
		UtilityClassObject.getTest().log(Status.PASS, "product added sucessfully");
		Reporter.log(productinfo + "  product added ", true);

		fbp.getSearchtxtfield().sendKeys(productName);

	}

}
