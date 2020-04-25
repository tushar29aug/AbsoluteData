package com.listeners;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.absolute.base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends Base {

	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports extent;
	
	public static ExtentReports createInstance(String filePath){
		
		htmlReport = new ExtentHtmlReporter(filePath);
		htmlReport.config().setDocumentTitle("Extent Report Title");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Test Report Name");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("Tester", "Tushar");
		extent.setSystemInfo("Project", "ABC");
		
		return extent;		
	}
	
	
public static String fileName;
	
	
	public static void captureScreenshot() throws IOException{
		
		Date d = new Date();		
		fileName = d.toString().replace(" ", "_").replace(":", "_");
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//test-output//Screenshot//"+fileName+".jpg"));
	}
}
