/*
 * @author chitta
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	static Action action = new Action();

	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	//Now we will use construtor to initialize these elements 
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		return action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		action.click(getDriver(), productResult);
		action.fluentWait(getDriver(), productResult, 10);
		return new AddToCartPage();
	}
}
