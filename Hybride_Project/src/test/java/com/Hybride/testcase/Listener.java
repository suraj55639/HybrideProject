package com.Hybride.testcase;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseClass implements ITestListener
{
	public void onTestFailure(ITestResult result) {
//		screenShot(result.getTestContext().getName()+"_"+result.getMethod().getMethodName()+".png");
 }
}	