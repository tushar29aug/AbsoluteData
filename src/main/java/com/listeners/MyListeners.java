package com.listeners;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import resourses.TestUtility;

public class MyListeners implements ITestListener{
	
	static Date d = new Date();
	static String  fileName = "Extent_"+d.toString().replace(" ", "_").replace(":", "_")+".html";
	
	public static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"/test-output"+fileName);
	public static ThreadLocal<ExtentTest> testReporter = new ThreadLocal<ExtentTest>();
	

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.YELLOW);
		try {
			ExtentManager.captureScreenshot();
			testReporter.get().fail("Screenshot: ", MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName).build());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		testReporter.get().fail(m);
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.YELLOW);
		testReporter.get().skip(m);
		
	}

	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getClass().getName()+"--"+result.getMethod().getMethodName());
		testReporter.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		Markup m = MarkupHelper.createLabel(methodName, ExtentColor.GREEN);
		testReporter.get().pass(m);
		
	}

}
