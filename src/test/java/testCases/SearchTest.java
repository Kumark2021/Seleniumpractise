package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.qa.Base;

public class SearchTest extends Base{
	public SearchTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	@BeforeMethod()
	
	public void setup()
	{
		
		driver=initBrowser(prop.getProperty("browser"));
	
	}
	
@AfterMethod()
	
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	
	public void searchWithValidproduct()
	{
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	
	@Test(priority=2)
	
	public void searchWithInvalidproduct()
	{
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		String actualSearchMsg=driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
		Assert.assertEquals(actualSearchMsg,dataProp.getProperty("noMatchProduct"),"The is no error message displayed");
		
		
	}
	
	@Test(priority=3)
	
	public void verifywithoutenringtheProduct()
	{
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		String actualSearchMsg=driver.findElement(By.xpath("/html/body/div[2]/div/div/p[2]")).getText();
		Assert.assertEquals(actualSearchMsg,"There is no product that matches the search criteria.","The is no error message displayed");
		
		
	}
}
