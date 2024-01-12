package com.Hybride.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
	
	Properties pro;
	public Readconfig()
	{
		File src =new File("./Configuration/config.properties/");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	
	public String  getApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String  getusername() {
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String  getuserpass() {
		String upass=pro.getProperty("password");
		return upass;
	}
}
