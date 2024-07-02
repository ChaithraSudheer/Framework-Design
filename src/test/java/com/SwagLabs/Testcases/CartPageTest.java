package com.SwagLabs.Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyRemove()
  {
	  cp.doRemove();
	  addWait();
  }
  
  @Test(priority=2)
  public void verifyContinueShopping()
  {
	  cp.doContinueShopping();
	  addWait();
	  //add product
	  ip.addToCart("Sauce Labs Fleece Jacket");
	  addWait();
	  //open cart page
	  cp.getCartPage();
	  addWait();
  }
  
  @Test(priority=3)
  public void verifyCheckout()
  {
	  String url=cp.doCheckout();
	  Assert.assertTrue(url.contains("checkout"), "Url is not matched");
	  System.out.println("Checkout Page is opened");
  }
  

  
}
