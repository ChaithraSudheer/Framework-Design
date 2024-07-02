package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage 
{
	//declare driver
	private WebDriver driver;
	
	//Initialize driver
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	//no of products available in inventory page
	private By plist=By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
	
	//name of each & every element
	private By pnlist=By.xpath("//div[@class='inventory_item_name ']");
	
	//click on add to cart
	private By addbtn=By.xpath("//button[text()='Add to cart']");
	
	//Methods
	public int getProductCount()
	{
		int count=driver.findElements(plist).size();
		return count;
	}
	
	public void getProductName()
	{
		List<WebElement> list=driver.findElements(pnlist);
		System.out.println("********Product names are: ************");
		for(WebElement i:list)
		{
			System.out.println(i.getText());
		}
	}
	
	public void addToCart(String pname)
	{
		List<WebElement> allproduct=driver.findElements(pnlist);
		for(WebElement i:allproduct)
		{
			if(i.getText().contains(pname))
			{
				i.click();
				break;
			}
		}
	 
		
		//add the product to cart
		driver.findElement(addbtn).click();
		System.out.println("Product added into the cart: "+pname);
	}
}
