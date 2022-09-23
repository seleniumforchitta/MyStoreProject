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

public class AccountCreationPage extends BaseClass {

	static Action action = new Action();

	@FindBy(xpath = "(//h3[@class='page-subheading'])[1]")
	WebElement createAccountFormTitle;
	
	//Now we will use construtor to initialize these elements 
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateAccountCreatePage() {
		return action.isDisplayed(getDriver(), createAccountFormTitle);
	}
	
}
