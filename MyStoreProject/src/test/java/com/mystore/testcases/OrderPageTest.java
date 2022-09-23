/**
 * @author chitt
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
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

public class OrderPageTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser);
	}
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPriceTest(String productName, String qty, String size) throws Throwable {
		Log.startTestCase("verifyTotalPriceTest");
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct(productName);
		addToCartPage = searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result = addToCartPage.validateAddToCart();
		Assert.assertTrue(result);
		orderPage = addToCartPage.clickOnProceedToCheckout();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		Log.endTestCase("verifyTotalPriceTest");
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
}
