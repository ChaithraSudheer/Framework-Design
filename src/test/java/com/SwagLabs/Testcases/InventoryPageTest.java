package com.SwagLabs.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyProductCount()
  {
	  int count=ip.getProductCount();
	  Assert.assertEquals(count,6, "Product count not matched");
	  System.out.println("Product count is as expected");
	  System.out.println("Total products are: "+count);
  }
  
  @Test(priority=2)
  public void verifyProductName()
  {
	  ip.getProductName();
  }
  
  @Test(priority=3)
  public void verifyAddToCart()
  {
	  ip.addToCart("Sauce Labs Fleece Jacket");
  }
  
  
}
