package com.SwagLabs.Testcases;

import org.testng.annotations.Test;

import com.SwagLabs.Utility.Utility;

public class OverviewPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifySummary() 
  {
	  op.getSummary();
	  addWait();
	  Utility.getScreenshot(driver);
  }
  
  @Test(priority=2)
  public void verifyOverview()
  {
	  op.doFinish();
	  addWait();
	  Utility.getScreenshot(driver);
  }
}
