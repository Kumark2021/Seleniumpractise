 package com.tutorial.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.utils.ExtentReport;

public class MyListeners implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTestName;

	@Override
	public void onTestStart(ITestResult result) {
		
		String testName = result.getName();
		extentTestName = extentReport.createTest(testName);
		extentTestName.log(Status.INFO, testName+"Execution started...");
		
		//System.out.println(testName+"Execution started...");		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();
		extentTestName.log(Status.PASS, testName+"Executed Successfully...");
		
		//System.out.println(testName+"Executed Successfully...");		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		
		WebDriver driver = null;
		
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenShot,new File(screenshotPath) );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentTestName.addScreenCaptureFromPath(screenshotPath);
		extentTestName.log(Status.INFO, result.getThrowable());

		
		extentTestName.log(Status.FAIL, testName+"Failed...");
		
		System.out.println(testName+"Failed...");
		;
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String testName = result.getName();
		extentTestName.log(Status.INFO, result.getThrowable());

		extentTestName.log(Status.SKIP, testName+"Skipped...");
		//System.out.println();
		//System.out.println(result.getThrowable());
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("Execution started...");
		
		 extentReport = ExtentReport.generateExtentReport();
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
		//System.out.println("Execution Finished...");
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\test-output\\extent-report\\extentReport.html";
		File extentReport=new File(pathOfExtentReport);
		
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
