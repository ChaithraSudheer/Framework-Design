package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	private WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	//open cart page
	private By cartpage=By.xpath("//a[@class='shopping_cart_link']");
	
	//remove button
	private By remove=By.xpath("//button[text()='Remove']");
	
	//continue shopping
	private By cbtn=By.xpath("//button[text()='Continue Shopping']");
	
	//checkout
	private By checkbtn=By.id("checkout");
	
	//methods
	public void getCartPage()
	{
		driver.findElement(cartpage).click();
		System.out.println("Cart page is opened");
	}

	public void doRemove()
	{
		driver.findElement(remove).click();
		System.out.println("Selected product got removed");
	}
	
	public void doContinueShopping()
	{
		driver.findElement(cbtn).click();
		System.out.println("Inventory page open: Select product");
	}
	
	public String doCheckout()
	{
		driver.findElement(checkbtn).click();
		return driver.getCurrentUrl();
	}
}
