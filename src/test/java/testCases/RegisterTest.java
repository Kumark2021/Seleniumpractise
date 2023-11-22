package testCases;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorial.qa.Base;
import com.tutorial.qa.pages.AccountSuccesPage;
import com.tutorial.qa.pages.Home;
import com.tutorial.qa.pages.RegisterPage;
import com.utils.Utilities;

public class RegisterTest extends Base {
	
	public RegisterTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	
	@BeforeMethod()
	
	public void setup()
	{
		
		driver=initBrowser(prop.getProperty("browser"));
		Home home=new Home(driver);
		home.clickOnMyAccount();
		home.selectRegisterOption();
		
		//driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		//driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterMethod()
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void registerWithMandatoryFields()
	{
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterRegisterfirstName(dataProp.getProperty("firstName"));
		registerpage.enterRegisterlasttName(dataProp.getProperty("lastName"));
		registerpage.enterRegisterEmaiField(Utilities.generateDateStamp());
		registerpage.enterRegisterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterRegisterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterRegisterconfirmPassword(prop.getProperty("validPassword"));
		registerpage.selectPrivacyPolicy();
		registerpage.clickOnContinue();
		
		

		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		/*driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();*/
		//String title=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		
		AccountSuccesPage successPage=new AccountSuccesPage(driver);
				
				String heading=successPage.verifyHeading();
				
		//String title=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		
		
		System.out.println("the tile of the page is "+ heading);
		Assert.assertEquals(heading,dataProp.getProperty("accountCreatedMsg"),"Account not created successfully");
				
	
	}
	
	@Test(priority=2)
	
	public void verifyWithAllfields()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterRegisterfirstName(dataProp.getProperty("firstName"));
		registerpage.enterRegisterlasttName(dataProp.getProperty("lastName"));
		registerpage.enterRegisterEmaiField(Utilities.generateDateStamp());
		registerpage.enterRegisterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterRegisterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterRegisterconfirmPassword(prop.getProperty("validPassword"));
		registerpage.selectYesNo();
		registerpage.selectPrivacyPolicy();
		registerpage.clickOnContinue();
		
		
			
		/*driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateDateStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		//String title=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		String title=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		System.out.println("the tile of the page is "+ title);
		Assert.assertEquals(title,dataProp.getProperty("accountCreatedMsg"),"Account not created successfully");*/
		
		AccountSuccesPage successPage=new AccountSuccesPage(driver);
		
		String heading=successPage.verifyHeading();
		
		//String title=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();


		System.out.println("the tile of the page is "+ heading);
		Assert.assertEquals(heading,dataProp.getProperty("accountCreatedMsg"),"Account not created successfully");
				
	
		
	}
	
	@Test(priority=3)
	public void verifyduplicateEmail()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.enterRegisterfirstName(dataProp.getProperty("firstName"));
		registerpage.enterRegisterlasttName(dataProp.getProperty("lastName"));
		registerpage.enterRegisterEmaiField(prop.getProperty("validEmail"));
		registerpage.enterRegisterTelephone(dataProp.getProperty("telephone"));
		registerpage.enterRegisterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterRegisterconfirmPassword(prop.getProperty("validPassword"));
		registerpage.selectYesNo();
		registerpage.selectPrivacyPolicy();
		registerpage.clickOnContinue();

		/*driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();*/
		
		String warningMsg=registerpage.verifyWarningmessageofDuplicateEmail();

		
		// warningMsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(warningMsg.contains(dataProp.getProperty("duplicateEamilMsg")),"Warning message not displayued");
		
			
	}

	@Test(priority=4)
	
	public void verifyWithoutFillingtheDetails()
	{
		//to click on the Register button
		//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
		
		//To clicking on the Continu button
		
		RegisterPage registerpage=new RegisterPage(driver);
		registerpage.clickOnContinue();


		
		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		
		String WarningMsg=registerpage.retrievePrivacyPolicyWarning();

		//String WarningMsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		Assert.assertTrue(WarningMsg.contains(dataProp.getProperty("policyMsg")),"Privacry errormessage is not didplayed");
		
		String firstNameMsg=registerpage.retrievefirstNameWarning();
		//String firstNameMsg=driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
		Assert.assertEquals(firstNameMsg,dataProp.getProperty("firstNamewarningMsg"),"Firstname error message is not displayed");
		
		String lastNameMsg=registerpage.retrieveLastNameWarning();

		
		//String lastNameMsg=driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
		Assert.assertEquals(lastNameMsg,dataProp.getProperty("lastNamewarningMsg"),"Lastname error message is not displayed");
		
		String emailWarningMsg=registerpage.retrieveEmailWarning();

		//String emailWarningMsg=driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
		Assert.assertEquals(emailWarningMsg,dataProp.getProperty("emailwarningMsgs"),"Email error message is not displayed");
		
		String telephoneWarningMsg=registerpage.retrieveTelephoneWarning();

		
		//String telephoneWarningMsg=driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
		Assert.assertEquals(telephoneWarningMsg,dataProp.getProperty("telephonemandatoryMsg"),"Telephone error message is not displayed");
		
		String passwordWarningMsg=registerpage.retrievepasswordWarning();

		//String passwordWarningMsg=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		Assert.assertEquals(passwordWarningMsg,dataProp.getProperty("passwordmandatoryMsg"),"password error message is not displayed");
		
		//String confirmPwdWarningMsg=driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText();
		//Assert.assertEquals(confirmPwdWarningMsg,"E-Mail Address does not appear to be valid!","Email error message is not displayed");
		
	}
}
