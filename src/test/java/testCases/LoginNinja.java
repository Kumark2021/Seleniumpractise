package testCases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginNinja {
	
	@Test()
	
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


}
