package ShoppingOnline.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import ShoppingOnline.TestComponents.BaseTest;


public class ValidateLoginTest extends BaseTest{
	
	
	
	
	 @Test(dataProvider = "getData" ,dataProviderClass = E_CommerceSoftcopyTest.class)
		
     public void validLogin(HashMap<String,String> input) {
		
	   landingPage.login(input.get("email"), input.get("password"));
		   String ActualMessage = landingPage.validLogin();
		
		   String expectedMessage = "Hello, " + input.get("userName");
		   System.out.println(ActualMessage);
		   Assert.assertEquals(ActualMessage, expectedMessage);
		
		   }
	

	
	
	
  
}

