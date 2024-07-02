package com.SwagLabs.Testcases;

import org.testng.annotations.Test;

public class CheckoutPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyCancel() 
  {
	  ch.doCancel();
	  addWait();
	  cp.doCheckout();
  }
  
  @Test(priority=2)
  public void verifyCheckout()
  {
	  ch.doContinue("Smitha", "Mohan", "411047");
  }
  
}
