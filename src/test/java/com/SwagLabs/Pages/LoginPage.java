package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	//initialize driver
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	private By username=By.id("user-name");
	private By password=By.id("password");
	private By loginbutton=By.id("login-button");
	
	//Methods
	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	
	public String doLogin(String un, String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(loginbutton).click();
		
		String curl=driver.getCurrentUrl();
		return curl;
	}
	
}
