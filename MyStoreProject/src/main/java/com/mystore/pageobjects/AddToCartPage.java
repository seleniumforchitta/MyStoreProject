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

public class AddToCartPage extends BaseClass{
	static Action action = new Action();

	@FindBy(id = "quantity_wanted")
	WebElement quantity;
	
	@FindBy(name = "group_1")
	WebElement size; 
	
	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartBtn; 
	
	@FindBy(xpath = "//i[@class='icon-ok']/..")
	WebElement addToCartMsg; 
	
	@FindBy(xpath = "//a[@title='Proceed to checkout']/span")
	WebElement proceedToCheckout; 
	
	//Now we will use construtor to initialize these elements 
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String qty) {
		 action.type(quantity, qty);
	}
	
	public void selectSize (String size1) {
		 action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() {
		action.JSClick(getDriver(), addToCartBtn);
		action.fluentWait(getDriver(), addToCartMsg, 10);
		
	}
	
	public boolean validateAddToCart() {
		action.fluentWait(getDriver(), addToCartMsg, 10);
		return action.isDisplayed(getDriver(), addToCartMsg);
	}
	
	public OrderPage clickOnProceedToCheckout() {
		action.click(getDriver(), proceedToCheckout);
		action.fluentWait(getDriver(), proceedToCheckout, 10);
		return new OrderPage();
	}
}
