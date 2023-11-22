package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement myAccountDropMenu;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	private WebElement loginOption;
	
	@FindBy(linkText=("Register"))
	private WebElement registerOption;
	
	
	//Actions
	
	public Home(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	public void clickOnMyAccount()
	{
		myAccountDropMenu.click();
	}
	
	public void selectLogin()
	{
		loginOption.click();
	}
	
	public void selectRegisterOption()
	{
		registerOption.click();
	}

}
