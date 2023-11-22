package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Objects
	
	@FindBy(id=("input-firstname")) 
	private WebElement enterFirstName;
	
	@FindBy(id=("input-lastname")) 
	private WebElement enterLasttName;
	
	@FindBy(id=("input-email")) 
	private WebElement enterEmailField;
	
	@FindBy(id=("input-telephone")) 
	private WebElement enterTelephoneNumer;
	
	@FindBy(id=("input-password")) 
	private WebElement enterPasswordField;
	
	@FindBy(id=("input-confirm")) 
	private WebElement enterPasswordConfirmField;
	
	@FindBy(name=("agree")) 
	private WebElement selectPrivacyField;
	
	@FindBy(xpath=("//*[@id=\"content\"]/form/div/div/input[2]"))
	private WebElement continueButton;
	
	@FindBy(xpath=("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]"))
	private WebElement selectradio;
	
	@FindBy(xpath=("//div[contains(@class,'alert-dismissible')]"))
	private WebElement warningMessage;
	
	//@FindBy(xpath=("//div[contains(@class,'alert-dismissible')]"))
	// WebElement privacyPolicyWarning;
	
	
	@FindBy(xpath=("//input[@id='input-firstname']/following-sibling::div"))
	private WebElement firstNameWarning;
	

	@FindBy(xpath=("//input[@id='input-lastname']/following-sibling::div"))
	private WebElement lastNameWarning;
	

	@FindBy(xpath=("//input[@id='input-email']/following-sibling::div"))
	private WebElement emailWarning;
	

	@FindBy(xpath=("//input[@id='input-telephone']/following-sibling::div"))
	private WebElement telephoneWarning;
	

	@FindBy(xpath=("//input[@id='input-password']/following-sibling::div"))
	private WebElement passswordWarning;
	

	//@FindBy(xpath=("//div[contains(@class,'alert-dismissible')]"))
	//private WebElement privacyPolicyWarning;
		
	
	
	
	
	
	//Actions
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterRegisterfirstName(String firstNameText)
	{
	enterFirstName.sendKeys(firstNameText);
	}	
	
	public void enterRegisterlasttName(String lastNameText)
	{
		enterLasttName.sendKeys(lastNameText);
	}		
	
	public void enterRegisterEmaiField(String emailText)
	{
		enterEmailField.sendKeys(emailText);
	}		
	
	public void enterRegisterTelephone(String telephoneText)
	{
		enterTelephoneNumer.sendKeys(telephoneText);
	}		
	
	public void enterRegisterPasswordField(String passwordfield)
	{
		enterPasswordField.sendKeys(passwordfield);
	}		
	
	public void enterRegisterconfirmPassword(String passwordfield)
	{
		enterPasswordConfirmField.sendKeys(passwordfield);
	}		
	
	public void selectPrivacyPolicy()
	{
		selectPrivacyField.click();
	}		
	
	public void clickOnContinue()
	{
		continueButton.click();
	}		
	
	public void selectYesNo()
	{
		selectradio.click();
		
	}
	
	public String verifyWarningmessageofDuplicateEmail()
	{
		String emailWarningMsg = warningMessage.getText();
		return emailWarningMsg;
	}
	

	public String retrievePrivacyPolicyWarning()
	{
	
		String privacyWarningmsg=warningMessage.getText();
		return privacyWarningmsg;
	}
	
	public String retrievefirstNameWarning()
	{
		String firstNamewarning=firstNameWarning.getText();
		return firstNamewarning;
	}
	
	
	public String retrieveLastNameWarning()
	{
		String lastNameWarningMsg=lastNameWarning.getText();
		return lastNameWarningMsg;
	}
	
	public String retrieveEmailWarning()
	{
		String emailWarningMsg = emailWarning.getText();
		return emailWarningMsg;
		
	}
	
	public String retrieveTelephoneWarning()
	{
		String teleWarningMsgs =telephoneWarning.getText();
		return teleWarningMsgs;
		
	}
	
	public String retrievepasswordWarning()
	{
		String passwordWarningMsg = passswordWarning.getText();
		return passwordWarningMsg;
		
	}
	
	
	
	
}
