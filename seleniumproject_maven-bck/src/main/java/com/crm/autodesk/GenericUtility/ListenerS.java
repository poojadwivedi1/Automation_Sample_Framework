package com.crm.autodesk.GenericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ListenerS implements ITestListener{
		ExtentReports reports;
		ExtentTest test; 

		public void onTestStart(ITestResult result) {
			test=reports.createTest(result.getMethod().getMethodName());
			}

		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS,result.getMethod().getMethodName()+"is Passed");
			
		}

		public void onTestFailure(ITestResult result) {
			test.log(Status.FAIL,result.getThrowable());
			test.log(Status.FAIL,result.getMethod().getMethodName()+"is Failed");
			
			BaseClass bc=new BaseClass();
			try {
				String path=bc.getscreenshot(result.getMethod().getMethodName());
				test.addScreenCaptureFromPath(path);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// TODO Auto-generated method stub
			
		}

		public void onTestSkipped(ITestResult result) {
			test.log(Status.SKIP, result.getMethod().getMethodName()+"is Skipped");
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
				}

		public void onStart(ITestContext context) {
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentREportsSDET21/ExtentReports.html");
		reports=new ExtentReports();
		reporter.config().setDocumentTitle("SDET21");
		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("BuildNo","5.1");
		reports.setSystemInfo("ENV", "Pre-Prod");
		reports.setSystemInfo("PLatform","Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");
		
		}

		public void onFinish(ITestContext context) {
			
			reports.flush();
				}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
		}


}
