package com.SwagLabs.Testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.SwagLabs.Pages.CartPage;
import com.SwagLabs.Pages.CheckoutPage;
import com.SwagLabs.Pages.InventoryPage;
import com.SwagLabs.Pages.LoginPage;
import com.SwagLabs.Pages.OverviewPage;
import com.SwagLabs.Utility.PropertiesUtil;
import com.SwagLabs.Utility.Utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public WebDriver driver;
	//declare object
	public LoginPage lp;
    public InventoryPage ip;
	public CartPage cp;
	public CheckoutPage ch;
	public OverviewPage op;
	public PropertiesUtil p1;
	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	
  @BeforeSuite
  public void reports()
  {
	  //create extent report instance 
	   extent=new ExtentReports();
	  
	  //using reporter add path
	  spark=new ExtentSparkReporter("Reports/SwagLab.html");
	  
	  //setup configuration
	  spark.config().setDocumentTitle("Sprint1 Report");
	  spark.config().setReportName("SwagLabAutomation Report");
	  spark.config().setTheme(Theme.DARK);
	  
	  //attached the report
	  extent.attachReporter(spark);
	  
	  //create test
	  test=extent.createTest("SwagLab End to End Report");
  }
  
  
  @BeforeTest
  public void setUpBrowser()
  {
	  p1=new PropertiesUtil();
	  driver=new ChromeDriver();
	  Reporter.log("Log:Driver session is created",true);
	 
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  //driver.get("https://www.saucedemo.com/");
	  driver.get(p1.getData("url"));
	  Reporter.log("Log:Application is opened", true);
	  test.pass("SwagLab application open successfully");
	  
	  
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
	  Reporter.log("Log:Login page is opened", true);
	  System.out.println("Title is: "+lp.getAppTitle());
	  
	  Utility.getScreenshot(driver);
	  //lp.doLogin("standard_user","secret_sauce");
	  lp.doLogin(p1.getData("un"), p1.getData("psw"));
	  Reporter.log("Log:Login is completed with valid data set", false);
	  test.pass("Login Completed...!");
	  addWait();
  
	  Utility.getScreenshot(driver);
	  
	  System.out.println("*********** Inventory Page ***********");
	  System.out.println("Total product count is: "+ip.getProductCount());
	  ip.getProductName();
	  addWait();
	  Utility.getScreenshot(driver);
	  //ip.addToCart("Sauce Labs Fleece Jacket");
	  ip.addToCart(p1.getData("pname1"));
	  addWait();
	  Utility.getScreenshot(driver);
	  //open cart page
	  cp.getCartPage();
	  addWait();
	  Utility.getScreenshot(driver);
	  test.pass("Inventory Page validation completed");
  
	  System.out.println("*********** Cart Page ***********");
	  cp.doRemove();
	  Utility.getScreenshot(driver);
	  addWait();
	  cp.doContinueShopping();
	  addWait();
	  Utility.getScreenshot(driver);
	  //ip.addToCart("Sauce Labs Bolt T-Shirt");
	  ip.addToCart(p1.getData("pname2"));
	  addWait();
	  cp.getCartPage();
	  addWait();
	  Utility.getScreenshot(driver);
	  cp.doCheckout();
	  addWait();
	  Utility.getScreenshot(driver);
	  test.pass("Cart Page validation completed...!");
  
	  System.out.println("********* Checkout Page *************");
	  //ch.doContinue("Smitha", "Mohan", "411047");
	  ch.doContinue(p1.getData("fn"), p1.getData("ln"), p1.getData("zc"));
	  addWait();
	  test.pass("Checkout Page Validation Completed...!");
	  
	  System.out.println("************ Overview Page **********");
	  test.pass("Overview Page validation completed...!");
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
  
  @AfterSuite
  public void exitReport()
  {
	  extent.flush();
  }
  
  
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
  }
}
