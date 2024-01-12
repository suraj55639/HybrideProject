package com.Hybride.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
//	
	public LoginPage(WebDriver driver)
	{
		driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userid;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginbtn;
	
	public void userid(String username)
	{
		userid.sendKeys(username);
	}
	
	public void password(String pword)
	{
		Password.sendKeys(pword);
	}
	
	public void clickbtn()
	{
		loginbtn.click();
	}
	
	
	
	
	
	
	
	
	

}
