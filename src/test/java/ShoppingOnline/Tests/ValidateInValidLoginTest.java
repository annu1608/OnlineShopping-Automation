package ShoppingOnline.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import ShoppingOnline.TestComponents.BaseTest;


public class ValidateInValidLoginTest extends BaseTest{
	
	
	
	
	@Test(dataProvider = "getInvalidLoginData", dataProviderClass = E_CommerceSoftcopyTest.class)
	public void InvalidLogin( HashMap<String,String> input) throws InterruptedException {
		
	      landingPage.login(input.get("email"), input.get("password"));
	      System.out.println("Please solve CAPTCHA manually within 30 seconds...");
	      Thread.sleep(30000);  // Wait for manual entry
          String ActualMessage = landingPage.InvalidLogin();
          String expectedMessage="Your password is incorrect";
			
			Assert.assertEquals(ActualMessage,expectedMessage);
		    System.out.println(ActualMessage);
	}
	
  
}

