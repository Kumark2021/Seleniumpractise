package com.tutorial.qa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utils.Utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public  Base() throws IOException
	{
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\Config.properties");		
		
		dataProp= new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorial\\qa\\testdata\\testdata.properties");
		FileInputStream datafis1 =new FileInputStream(dataPropFile);
		dataProp.load(datafis1);
		
		try {
			FileInputStream fis =new FileInputStream(propFile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public WebDriver initBrowser(String browser)

	{
		//String browser="chrome";
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver =new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver =new EdgeDriver();
		}
		//driver =new ChromeDriver();
		//driver.manage().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		return driver;
		
		
	}
}
