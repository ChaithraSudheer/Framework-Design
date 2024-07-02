package com.SwagLabs.Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SwagLabs.Pages.*;
import com.SwagLabs.Utility.Utility;

import org.testng.annotations.*;

public class BaseClass {
	
	public WebDriver driver;
	//declare object
	public LoginPage lp;
    public InventoryPage ip;
	public CartPage cp;
	public CheckoutPage ch;
	public OverviewPage op;
	
  @BeforeTest
  public void setUpBrowser()
  {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.get("https://www.saucedemo.com/");
	  
	  //initialize object
	  lp=new LoginPage(driver);
	  ip=new InventoryPage(driver);
	  cp=new CartPage(driver);
	  ch=new CheckoutPage(driver);
	  op=new OverviewPage(driver);

	  
  
  }
  
  @BeforeClass//Page precondition
  public void pageSetUp()
  {
	  System.out.println("********** Login Page ***********");
	  System.out.println("Url is: "+lp.getUrl());
	  System.out.println("Title is: "+lp.getAppTitle());
	  
	  Utility.getScreenshot(driver);
	  lp.doLogin("standard_user","secret_sauce");
	  addWait();
  
	  Utility.getScreenshot(driver);
	  
	  System.out.println("*********** Inventory Page ***********");
	  System.out.println("Total product count is: "+ip.getProductCount());
	  ip.getProductName();
	  addWait();
	  Utility.getScreenshot(driver);
	  ip.addToCart("Sauce Labs Fleece Jacket");
	  addWait();
	  Utility.getScreenshot(driver);
	  //open cart page
	  cp.getCartPage();
	  addWait();
	  Utility.getScreenshot(driver);
  
	  System.out.println("*********** Cart Page ***********");
	  cp.doRemove();
	  addWait();
	  cp.doContinueShopping();
	  addWait();
	  Utility.getScreenshot(driver);
	  ip.addToCart("Sauce Labs Bolt T-Shirt");
	  addWait();
	  cp.getCartPage();
	  addWait();
	  Utility.getScreenshot(driver);
	  cp.doCheckout();
	  addWait();
	  Utility.getScreenshot(driver);
  
	  System.out.println("********* Checkout Page *************");
	  ch.doContinue("Smitha", "Mohan", "411047");
	  addWait();
	  
	  System.out.println("************ Overview Page **********");
	    
  }
  
  public void addWait()
  {
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
  }
}
