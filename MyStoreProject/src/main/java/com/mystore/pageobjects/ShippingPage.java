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

public class ShippingPage extends BaseClass{
	static Action action = new Action();

	@FindBy(id = "cgv")
	WebElement terms;
	
	@FindBy(xpath = "//button[@name='processCarrier']/span")
	WebElement proceedToCheckout;
	
	//Now we will use construtor to initialize these elements 
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checktheTerms() {
		action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckout() {
		action.click(getDriver(), proceedToCheckout);
		return new PaymentPage();
	}
}
