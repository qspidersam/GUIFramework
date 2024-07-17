package alphaware.ecommerce.admin.Login;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.FeaturesPage;
import com.comcast.crm.objectrepositoryutility.Homepage;

/**
 * 
 * @author supriya
 *
 */

@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class StockOutProductINFeatureTest extends AdminBaseClass {

	/**
	 * Test script for stock out the product
	 * 
	 * @throws Throwable
	 */

	@Test
	public void stockout() throws Throwable {
		/*
		 * fetching expectedfeaturespagetitle and expectedStockinpagetitle data from
		 * excel for verification
		 */

		String expectedfeaturespagetitle = eLib.getDataFromExcel("alpha", 23, 0);
		String expectedStockoutpagetitle = eLib.getDataFromExcel("alpha", 23, 1);

		/* creating object of homepage and clicking on Featureslink */

		Homepage hp = new Homepage(driver);
		wlib.mousemoveOnElement(driver, hp.getProductlink());
		hp.getFeatureslink().click();

		/* creating object of FeaturesPage and fetching initalstocks of puma */

		FeaturesPage fp = new FeaturesPage(driver);
		String actfeaturespagetitle = fp.getFeaturespagetitle().getText();
		Assert.assertEquals(expectedfeaturespagetitle, actfeaturespagetitle);
		Reporter.log(actfeaturespagetitle + "  featurespage is displaying", true);

		/* capturing the stock info */

		String initalstocks = driver.findElement(By.xpath("//td[text()='Flyknit 360']/../td[5]")).getText();
		Reporter.log("initalstocks" + "=" + initalstocks, true);
		
	/* 	clicking  on Flyknit360stockoutbtn and entering the number of stocks to be decreased */

		fp.getFlyknit360stockoutbtn().click();
		wlib.waitForElementPresent(driver, fp.getStockoutpagetitle());
		String actStockoutpagetitle = fp.getStockoutpagetitle().getText();
		Assert.assertEquals(expectedStockoutpagetitle, actStockoutpagetitle);
		Reporter.log(actStockoutpagetitle + "  Stockoutpage is displaying", true);

		String numofstocks = eLib.getDataFromExcel("alpha", 1, 1);
		fp.getStockoutnumbertextfield().sendKeys(numofstocks);
		wlib.waitForElementPresent(driver, fp.getStockOutsavedatabtn());
		fp.getStockOutsavedatabtn().click();
		Thread.sleep(5000);
		/*capturing the decreasedstocks info*/

		String decreasedstocks = driver.findElement(By.xpath("//td[text()='Flyknit 360']/../td[5]")).getText();
		Reporter.log("decreasedstocks" + "= " + decreasedstocks, true);

		Assert.assertNotEquals(initalstocks, decreasedstocks);

		UtilityClassObject.getTest().log(Status.PASS, "no of stocks is sucessfully decreased");
		Reporter.log("no of stocks is decreased", true);

	}
}
