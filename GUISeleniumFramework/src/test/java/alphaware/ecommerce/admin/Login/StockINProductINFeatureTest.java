package alphaware.ecommerce.admin.Login;

import org.openqa.selenium.By;


import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.listenerutility.ListImpClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.FeaturesPage;
import com.comcast.crm.objectrepositoryutility.Homepage;
/**
 * @author supriya
 */


@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class StockINProductINFeatureTest extends AdminBaseClass {
	/**
	 * Test script for stock in the product
	 * @throws Throwable
	 */
	
	@Test
	public void stockin() throws Throwable {
		/* fetching expectedfeaturespagetitle and  expectedStockinpagetitle data from excel for verification*/
		
		String expectedfeaturespagetitle = eLib.getDataFromExcel("alpha", 19, 0);
		String expectedStockinpagetitle = eLib.getDataFromExcel("alpha", 19, 1);
		
		/* creating object of homepage and clicking on Featureslink */
		
		Homepage hp = new Homepage(driver);
		wlib.mousemoveOnElement(driver,hp.getProductlink());
		hp.getFeatureslink().click();
		
		/* creating object of FeaturesPage and fetching initalstocks of puma*/
		
		FeaturesPage fp= new FeaturesPage(driver);
		String actfeaturespagetitle = fp.getFeaturespagetitle().getText();
		Assert.assertEquals(expectedfeaturespagetitle, actfeaturespagetitle);
	    Reporter.log(actfeaturespagetitle +"  featurespage is displaying", true);
	    
	    /* capturing the stock info*/
		String initalstocks = driver.findElement(By.xpath("//td[text()='puma']/../td[5]")).getText();
		Reporter.log("initalstocks"+"="+initalstocks,true);
		
		/* clicking on Pumastockinbtn and entering the no.of stocks to be increased*/
		 
		fp.getPumastockinbtn().click();
		wlib.waitForElementPresent(driver, fp.getStockinpagetitle());
		
		String actStockinpagetitle = fp.getStockinpagetitle().getText();
		Assert.assertEquals(expectedStockinpagetitle, actStockinpagetitle);
	    Reporter.log(actStockinpagetitle +"  Stockinpage is displaying", true);

		
		
		wlib.waitForElementPresent(driver, fp.getstockinnumbertextfield());
		String numofstocks = eLib.getDataFromExcel("alpha", 1, 0);
		fp.getstockinnumbertextfield().sendKeys(numofstocks);
		
	/* click on save btn to be inceased the stocks of the product */
		fp.getstockINsavedatabtn().click();
         
		String icreasedstocks = driver.findElement(By.xpath("//td[text()='puma']/../td[5]")).getText();
		Reporter.log("icreasedstocks"+"= "+icreasedstocks,true);
        
	
	    Assert.assertNotEquals(initalstocks, icreasedstocks);
		
		UtilityClassObject.getTest().log(Status.PASS, "no of stocks is sucessfully increased");
		Reporter.log("no of stocks is increased", true);
		
		
		
	
		
		
		
		
	}
	
	

}
