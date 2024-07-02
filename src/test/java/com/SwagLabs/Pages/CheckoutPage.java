package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage 
{
	
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	private By fname=By.id("first-name");
	private By lname=By.id("last-name");
	private By zcode=By.id("postal-code");
	private By cbtn=By.id("cancel");
	private By continuebtn=By.id("continue");
	
	//Methods
	public void doCancel()
	{
		driver.findElement(cbtn).click();
		System.out.println("Checkout Process Cancelled");
	}
	
	public void doContinue(String fn, String ln, String zc)
	{
		driver.findElement(fname).sendKeys(fn);
		driver.findElement(lname).sendKeys(ln);
		driver.findElement(zcode).sendKeys(zc);
		driver.findElement(continuebtn).click();
		System.out.println("Overview page open");
	}
}
