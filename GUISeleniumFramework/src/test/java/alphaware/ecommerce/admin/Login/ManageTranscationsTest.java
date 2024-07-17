package alphaware.ecommerce.admin.Login;

import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.AdminBaseClass;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.Homepage;
import com.comcast.crm.objectrepositoryutility.Receiptpage;
import com.comcast.crm.objectrepositoryutility.TransactionsPage;

/**
 * 
 * @author supriya
 *
 */


@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)

public class ManageTranscationsTest extends AdminBaseClass {
	/**
	 * Test script for manage transcations
	 * @throws Throwable
	 */

	@Test
	public void TranscationsTest() throws Throwable {
		/*fetching expectedtranscactionspagetitle and  expectedReceiptpage data from excel for verification */
		String expectedtranscactionspagetitle = eLib.getDataFromExcel("alpha", 15, 0);
		String expectedReceiptpage = eLib.getDataFromExcel("alpha", 15, 1);
		
		/*creating object of homepage and clicking on Transactionslink */
		Homepage hp = new Homepage(driver);
		hp.getTransactionslink().click();
		
		/* creating object of TransactionsPage  */
		TransactionsPage tp = new TransactionsPage(driver);
		String acttranscactionspagetitle = tp.getTranscactionspagetitle().getText();
		

		Assert.assertEquals(expectedtranscactionspagetitle, acttranscactionspagetitle);
	    Reporter.log(acttranscactionspagetitle +" transcactionspage is displaying", true);
	    
	    /*clicking on view link of ID66 */


		tp.getID66viewbtn().click();
		
		/*creating object of Receiptpage and verifying */
		Receiptpage rp = new Receiptpage(driver);
		String actReceiptpage = rp.getReceiptpagetitle().getText();

		Assert.assertEquals(expectedReceiptpage, actReceiptpage);
		UtilityClassObject.getTest().log(Status.PASS, "Receiptpage is displaying");
	    Reporter.log(actReceiptpage +"  Receiptpage displayed", true);


	}

}
