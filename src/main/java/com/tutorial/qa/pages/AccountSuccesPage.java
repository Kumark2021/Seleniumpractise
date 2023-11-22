package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccesPage {

	WebDriver driver;
	// Objects
	
	@FindBy(xpath=("//div[@id='content']/h1"))
	private WebElement accountSuccessHeading;
	
	
	
	
	//Actions
	
	public AccountSuccesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHeading()
	{
		String accountSuccessHeadingText = accountSuccessHeading.getText();	
		return accountSuccessHeadingText;
	}
			
}
