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

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable{
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("User is going to click on SignIn");
		loginPage = indexPage.clickOnSignIn(); //As it reurns the LoginPage object
		Log.info("User will enter Username & Password");
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Adding using data provider - TestData.xslx
		homePage = loginPage.login(uname, pswd);
		String actualURL = homePage.getCurrentURL();
		String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is successful");
		Log.endTestCase("loginTest");
		
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
