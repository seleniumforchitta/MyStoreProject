/**
 * @author chitt
 *
 */
package com.mystore.testcases;

import org.testng.Assert;
import com.mystore.utility.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;


public class AccountCreationPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
	}
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void createAccountTest(String email) throws Throwable  {
		Log.startTestCase("createAccountTest");
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn(); //As it reurns the LoginPage object
		accountCreationPage = loginPage.createNewAccount(email);
		boolean result = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(result);
		Log.endTestCase("createAccountTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
