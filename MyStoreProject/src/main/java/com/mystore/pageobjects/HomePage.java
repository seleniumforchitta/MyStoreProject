/**
 * @author chitta
 *
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	static Action action = new Action();
	
	@FindBy(xpath = "//span[text()='My wishlists']")
	WebElement myWishlist; 
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement orderHistory;
	
	//Now we will use construtor to initialize these elements 
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyWishlist() {
		return action.isDisplayed(getDriver(),myWishlist);
	}
	
	public boolean validateOrderHistory() {
		return action.isDisplayed(getDriver(),orderHistory);
	}
	
	public String getCurrentURL() {
		String homePageURL = action.getCurrentURL(getDriver());
		return homePageURL;
	}
}
