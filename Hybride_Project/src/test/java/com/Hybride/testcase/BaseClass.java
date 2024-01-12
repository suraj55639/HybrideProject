package com.Hybride.testcase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
}
