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

public class OrderPage extends BaseClass{
	static Action action = new Action();

	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//p/a[@title='Proceed to checkout']/span")
	WebElement proceedToCheckout;
	
	//Now we will use construtor to initialize these elements 
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice() {
		 String unitPrice1 = unitPrice.getText();
		 String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		 double finalUnitPrice = Double.parseDouble(unit);
		 return finalUnitPrice/100;
	}
	
	public double getTotalPrice() {
		 String totalPrice1 = totalPrice.getText();
		 String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		 double finalTotalPrice = Double.parseDouble(total);
		 return finalTotalPrice/100;
	}
	
	public LoginPage clickOnProceedToCheckout() {
		action.click(getDriver(), proceedToCheckout);
		return new LoginPage();
	}
}
