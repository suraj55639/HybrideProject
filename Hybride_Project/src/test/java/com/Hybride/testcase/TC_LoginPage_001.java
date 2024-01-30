package com.Hybride.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Hybride.pageObject.LoginPage;

public class TC_LoginPage_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException
	{
		 logger.info("Url is open");
		 LoginPage lp=new LoginPage(driver);
		 
		 
		 logger.info("Enter user id");
		 lp.userid(username);
		 Thread.sleep(1000);
		 logger.info("Enter password");
		 lp.password(password);
		 lp.clickbtn();
		 logger.info("Enter submit button");
		 Thread.sleep(1000);
		 logger.info("Login Successfull");
		 
		 
		 if(driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
			{
				Assert.assertTrue(true);
				logger.info("Login test passed");
			}
			else
			{
				Assert.assertTrue(false);
				logger.info("Login test failed");
			}
		 
	}

}
