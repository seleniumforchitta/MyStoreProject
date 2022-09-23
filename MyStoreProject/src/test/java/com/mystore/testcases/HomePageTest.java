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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class HomePageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("wishListTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn(); //As it reurns the LoginPage object
		homePage=loginPage.login(uname,pswd);
		boolean result = homePage.validateMyWishlist();
		Assert.assertTrue(result);
		Log.endTestCase("wishListTest");
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryAndDetailsTest(String uname, String pswd) throws Throwable {
		Log.startTestCase("orderHistoryandDetailsTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn(); //As it reurns the LoginPage object
		homePage=loginPage.login(uname,pswd);
		boolean result = homePage.validateOrderHistory();
		Assert.assertTrue(result);
		Log.endTestCase("orderHistoryandDetailsTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
