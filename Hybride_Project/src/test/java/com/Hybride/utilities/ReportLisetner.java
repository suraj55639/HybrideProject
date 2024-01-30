package com.Hybride.utilities;


	//Listener class used to generate Extent reports

	import java.io.File;
	import java.io.IOException;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import com.Hybride.testcase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.markuputils.ExtentColor;
	import com.aventstack.extentreports.markuputils.MarkupHelper;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	
	
	public class ReportLisetner extends BaseClass implements ITestListener {

		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest logger;
		
			
		public void onStart(ITestContext testContext)
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			String repName="Test-Report-"+timeStamp+".html";
			
			sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
			
			extent=new ExtentReports();
			
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Host name","localhost");
			extent.setSystemInfo("Environemnt","QA");
			extent.setSystemInfo("user","pavan");
			
			sparkReporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
			sparkReporter.config().setReportName("Functional Test Automation Report"); // name of the report
			sparkReporter.config().setTheme(Theme.DARK);
		}
		
		public void onTestSuccess(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in th report
			logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
		}
		
		public void onTestFailure(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in th report
			logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
			
			
				screenShot(tr.getTestContext().getName()+"_"+tr.getMethod().getMethodName()+".png");

			
		}
		
		public void onTestSkipped(ITestResult tr)
		{
			logger=extent.createTest(tr.getName()); // create new entry in th report
			logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
		}
		
		public void onFinish(ITestContext testContext)
		{
			extent.flush();
		}
	}


