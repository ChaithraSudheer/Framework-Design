package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage 
{
	private WebDriver driver;
	
	public OverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	private By summary=By.xpath("//div[@class='summary_info']//div[contains(@class,'summary')]");
	private By fbtn=By.id("finish");
	private By msg=By.tagName("h2");
	
	//methods
	public void getSummary()
	{
		List<WebElement> all=driver.findElements(summary);
		for(WebElement i:all)
		{
			System.out.println(i.getText());
		}
	}
	
	public void doFinish()
	{
		driver.findElement(fbtn).click();
		String text=driver.findElement(msg).getText();
		System.out.println("Final status is: "+text);
	}

}
