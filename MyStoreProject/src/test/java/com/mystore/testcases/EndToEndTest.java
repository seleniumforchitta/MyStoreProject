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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;
import com.mystore.utility.Log;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary ordersummary;
	OrderConfirmationPage orderConfirmationPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws InterruptedException {
		Log.startTestCase("endToEndTest");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage = addToCartPage.clickOnProceedToCheckout();
		loginPage = orderPage.clickOnProceedToCheckout();
		addressPage = loginPage.loginInMiddle(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage = addressPage.clickOnProceedToCheckout();
		shippingPage.checktheTerms();
		paymentPage = shippingPage.clickOnProceedToCheckout();
		ordersummary = paymentPage.clickOnPaymentMethod();
		orderConfirmationPage = ordersummary.clickOnIConfirmMyOrder();
		String actualMsg = orderConfirmationPage.validateConfirmationMsg();
		String expectedMsg = "Your order on My Store is complete.";
		Log.info("Verifying if order on My Store is complete.");
		Assert.assertEquals(actualMsg, expectedMsg);
		Log.info("Your order on My Store is complete.");
		Log.endTestCase("endToEndTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
