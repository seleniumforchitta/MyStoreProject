package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	static Action action = new Action();
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement myStoreLogo;
	
	@FindBy(id = "search_query_top")
	WebElement searchProductBox;
	
	@FindBy(name = "submit_search")
	WebElement searchProductBtn;
	
	//Now we will use construtor to initialize these elements 
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	//Now to we will write methods that can be done in this page
	public LoginPage clickOnSignIn() {
		action.fluentWait(getDriver(), signInBtn, 10);
		action.click(getDriver(),signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return action.isDisplayed(getDriver(),myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}
	
	public SearchResultPage searchProduct(String productName) {
		action.type(searchProductBox, productName);
		action.click(getDriver(),searchProductBtn);
		return new SearchResultPage();
	}
}
