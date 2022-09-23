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


public class LoginPage extends BaseClass {
	static Action action = new Action();
	
	@FindBy(id = "email")
	WebElement userName;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	WebElement signInBtn;
	
	@FindBy(name = "email_create")
	WebElement emailForNewAccount;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']/span")
	WebElement createNewAccountBtn;
	
	//Now we will use construtor to initialize these elements 
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) {
		action.type(userName,uname);
		action.type(password,pswd);
		action.click(getDriver(),signInBtn);
		return new HomePage();
	}
	
	public AddressPage loginInMiddle(String uname, String pswd) {
		action.type(userName,uname);
		action.type(password,pswd);
		action.click(getDriver(),signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail) {
		action.type(emailForNewAccount,newEmail);
		action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}

}
