package com.Hybride.testcase;



	import java.io.IOException;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.Hybride.pageObject.AddCustomerPage;
	import com.Hybride.pageObject.LoginPage;


	public class TC_AddCustomer extends BaseClass {
		@Test
		public void addNewCustomer() throws InterruptedException, IOException
		{
			LoginPage lp=new LoginPage(driver);
			lp.userid(username);
			logger.info("User name is provided");
			lp.password(password);
			logger.info("Passsword is provided");
			lp.clickbtn();
			
//			Thread.sleep(3000);
			
			AddCustomerPage addcust=new AddCustomerPage(driver);
			
			addcust.clickAddNewCustomer();
			
			logger.info("providing customer details....");
			
			
			addcust.custName("suraj");
			addcust.custgender("male");
			addcust.custdob("10","15","1994");
			Thread.sleep(5000);
			addcust.custaddress("INDIA");
			addcust.custcity("HYD");
			addcust.custstate("AP");
			addcust.custpinno("5000074");
			addcust.custtelephoneno("987890091");
			
			String email=randomestring()+"@gmail.com";
			addcust.custemailid(email);
			addcust.custpassword("abcdef");
			addcust.custsubmit();
			
			Thread.sleep(3000);
			
			logger.info("validation started....");
			
			boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
			
			if(res==true)
			{
				Assert.assertTrue(true);
				logger.info("test case passed....");
				
			}
			else
			{
				logger.info("test case failed....");
				Assert.assertTrue(false);
			}
				
		}
		
		
	}

