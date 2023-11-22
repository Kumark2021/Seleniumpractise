package testCases;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.tutorial.qa.Base;
import com.tutorial.qa.pages.AccountPage;
import com.tutorial.qa.pages.Home;
import com.tutorial.qa.pages.LoginPage;
import com.utils.Utilities;

public class LoginNinjaTest extends Base {
	public LoginNinjaTest() throws IOException  {
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
		home.selectLogin();
		
		//driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
	}
	
	@AfterMethod()
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="validDataExcel")
	
	public void NinjaLogin(String email,String password) throws InterruptedException {
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterpassword(password);
		loginpage.clikonLogin();
		
	
	//driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys(email);
	//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
	//Thread.sleep(20);
	//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
//	String expectedTitle="My Account";
		
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.getDisplayStatus(),"Edit information is not displayed");

	
	//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());


	}
	@DataProvider(name="validDataExcel")
	public Object[][] supplyTestData()
	{
		
		Object[][] data=Utilities.getTestDatafromExcel("Login");
		return data;
	}
	
	@Test(priority=2)
	
	public void verifyInvalidLogin()
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateDateStamp());
		loginpage.enterpassword(dataProp.getProperty("invalidPassword"));
		loginpage.clikonLogin();
		
		//driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(dataProp.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String warningmsg=loginpage.retriveEmailPasswordNotMatching();

		//String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg=dataProp.getProperty("emailvalidNoMatching");				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		
		
	}
	
	
	
	@Test(priority=3)
	
	public void loginwithInvalidEmailandValidpassword()
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(Utilities.generateDateStamp());
		loginpage.enterpassword(dataProp.getProperty("invalidPassword"));
		loginpage.clikonLogin();
		
		//driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys(Utilities.generateDateStamp());
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(dataProp.getProperty("validPassword"));
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		String warningmsg=loginpage.retriveEmailPasswordNotMatching();

		//String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg="Warning: No match for E-Mail Address and/or Password.";				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		
		
	}

	@Test(priority=4)
	
	public void loginwithValidemailandInvalidemail()
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterEmailAddress(prop.getProperty("validEmail"));
		loginpage.enterpassword(dataProp.getProperty("invalidPassword"));
		loginpage.clikonLogin();
		
		
		/*driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();*/
		
		String warningmsg=loginpage.retriveEmailPasswordNotMatching();
		//String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg=dataProp.getProperty("emailvalidNoMatching");				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		
		
		
		
	}
	@Test(priority=5)
	public void withoutEmailandPassword()
	
		{
		
		LoginPage loginpage=new LoginPage(driver);
		
		loginpage.clikonLogin();
		/*driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();*/
		
		String warningmsg=loginpage.retriveEmailPasswordNotMatching();

		//String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg=dataProp.getProperty("emailvalidNoMatching");			
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		
		
	}

}
