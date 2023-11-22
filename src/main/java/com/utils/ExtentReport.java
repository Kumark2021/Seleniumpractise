package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	public static ExtentReports generateExtentReport()
	
	{
		ExtentReports extentReport=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\extent-report\\extentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("NinjaTutorial TestResults" );
		sparkReporter.config().setDocumentTitle("NJ TestResults");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\config\\Config.Properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configPropFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			configProp.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser",configProp.getProperty("browser"));
		extentReport.setSystemInfo("Valid email",configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("Valid Password",configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating Systerm",System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name",System.getProperty("user.name"));

		extentReport.setSystemInfo("java version",System.getProperty("java.version"));
		return extentReport;





		
		
		
	}
	

}
