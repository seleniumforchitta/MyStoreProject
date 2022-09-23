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

public class OrderSummary extends BaseClass{
	static Action action = new Action();

	@FindBy(xpath = "(//button[@type='submit'])[2]/span")
	WebElement IConfirmMyOrder;
	
	//Now we will use construtor to initialize these elements 
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderConfirmationPage clickOnIConfirmMyOrder() throws InterruptedException {
		action.fluentWait(getDriver(), IConfirmMyOrder, 10);
		action.click1(IConfirmMyOrder, "IConfirmMyOrder");
		Thread.sleep(6000);
		return new OrderConfirmationPage();
	}
}
