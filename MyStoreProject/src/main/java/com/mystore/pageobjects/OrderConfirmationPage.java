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


public class OrderConfirmationPage extends BaseClass {
	static Action action = new Action();

	@FindBy(xpath = "//p[contains(text(),'Your order on My Store is complete.')]")
	WebElement confirmationMsg;
	
	//Now we will use construtor to initialize these elements 
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String validateConfirmationMsg() {
		String confirmMsg = confirmationMsg.getText();
		return confirmMsg;
	}
}
