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

public class PaymentPage extends BaseClass{
	static Action action = new Action();

	@FindBy(xpath = "//a[@class='bankwire']")
	WebElement bankwireMethod;
	
	@FindBy(xpath = "//a[@class='cheque']")
	WebElement payByChequeMethod;
	
	//Now we will use construtor to initialize these elements 
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws InterruptedException {
		action.fluentWait(getDriver(), payByChequeMethod, 10);
		action.click1(payByChequeMethod,"payByChequeMethod");
		Thread.sleep(6000);
		return new OrderSummary();
	}
}
