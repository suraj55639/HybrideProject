package com.Hybride.testcase;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Hybride.utilities.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static String ScreeShotFolder;
	Readconfig rc=new Readconfig();
	public  String baseUrl=rc.getApplicationUrl();
	public  String username=rc.getusername();
	public  String password=rc.getuserpass();
	public  static  WebDriver driver;
	public  static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
    public void setUp(String bro) 
    {
		logger=LogManager.getLogger("BaseClass");
//   	 PropertyConfigurator.configure("Log4j2.properties");
		
		if(bro.endsWith("Edge")) {
    	WebDriverManager.edgedriver().setup();
    	 driver=new EdgeDriver();
		}  
		
		else if(bro.endsWith("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	 driver=new ChromeDriver();
			}  
		else if(bro.endsWith("ie")) {
	    	WebDriverManager.iedriver().setup();
	    	 driver=new InternetExplorerDriver();
			}  
		else if(bro.endsWith("firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	 driver=new FirefoxDriver();
			}  
		 driver.get(baseUrl);
    }
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void screenShot(String filename)
	{
		if(ScreeShotFolder == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
			ScreeShotFolder = myDateObj.format(myFormatObj);
		}		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("./ScreeShot/"+ScreeShotFolder+"/"+filename);
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.err.println("ScreenShot Successfully");
	}
}
