package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//*[@id=\"input-email\"]")
	private WebElement emailAddress;
	
	@FindBy(xpath="//*[@id=\"input-password\"]")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
    private WebElement loginButton; 
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMathcingWarning;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
	public void enterEmailAddress(String emailText)
	{
		emailAddress.sendKeys(emailText);
	}
	public void enterpassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	public void clikonLogin()
	{
		loginButton.click();
	}
	
	public String retriveEmailPasswordNotMatching()
	{
		String warnText=emailPasswordNotMathcingWarning.getText();
		return warnText;
	}

}
