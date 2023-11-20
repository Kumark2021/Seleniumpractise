package testCases;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginNinja {
	
	@Test(priority=1)
	
	public void NinjaLogin() throws InterruptedException {
	WebDriver driver =new ChromeDriver();
	//driver.manage().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://tutorialsninja.com/demo/");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
	driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("amootoricap9@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345");
	Thread.sleep(20);
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
	
//	String expectedTitle="My Account";
	
	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());

	driver.quit();
	}
	
	@Test(priority=2)
	
	public void verifyInvalidLogin()
	{
		WebDriver driver =new ChromeDriver();
		//driver.manage().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("amootoricap239"+generateDateStamp()+"@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("1245");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		
		String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg="Warning: No match for E-Mail Address and/or Password.";				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		driver.quit();
		
	}
	
	public String generateDateStamp()
	{
		Date date=new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
		
				
	}
	
	@Test(priority=3)
	
	public void loginwithInvalidEmailandValidpassword()
	{
		WebDriver driver =new ChromeDriver();
		//driver.manage().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("amootoricap239"+generateDateStamp()+"@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		
		String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg="Warning: No match for E-Mail Address and/or Password.";				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		driver.quit();
		
	}

	@Test(priority=4)
	
	public void loginwithValidemailandInvalidemail()
	{
		WebDriver driver =new ChromeDriver();
		//driver.manage().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("amootoricap9@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("1245");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		
		String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg="Warning: No match for E-Mail Address and/or Password.";				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		driver.quit();
		
		
		
	}
	@Test(priority=5)
	public void withoutEmailandPassword()
	{
		WebDriver driver =new ChromeDriver();
		//driver.manage().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		driver.findElement((By.xpath("//*[@id=\"input-email\"]"))).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		
		String warningmsg=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMsg="Warning: No match for E-Mail Address and/or Password.";				
		Assert.assertTrue(warningmsg.contains(expectedWarningMsg), "Expected Message not displayed");
		driver.quit();
		
		
	}

}
