/**
 * @author chitt
 *
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {
	
	static Action action = new Action();

	@FindBy(xpath = "//button[@name='processAddress']/span")
	WebElement proceedToCheckout;
	
	//Now we will use construtor to initialize these elements 
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage clickOnProceedToCheckout() {
		action.click(getDriver(), proceedToCheckout);
		return new ShippingPage();
	}

}
