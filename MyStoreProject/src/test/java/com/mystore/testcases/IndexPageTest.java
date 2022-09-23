/**
 * @author chitta
 *
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage indexPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = "Smoke")
	public void myStroreLogoTest() {
		Log.startTestCase("myStroreLogoTest");
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
		Log.endTestCase("myStroreLogoTest");
	}
	
	@Test(groups = "Smoke")
	public void myStroreTitleTest() {
		Log.startTestCase("myStroreTitleTest");
		String acttitle = indexPage.getMyStoreTitle();
		Assert.assertEquals(acttitle,"My Store");
		Log.endTestCase("myStroreTitleTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
}
