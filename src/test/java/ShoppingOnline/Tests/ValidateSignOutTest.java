package ShoppingOnline.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import ShoppingOnline.TestComponents.BaseTest;


public class ValidateSignOutTest extends BaseTest{
	
	  
	@Test(dataProvider = "getData", dataProviderClass = E_CommerceSoftcopyTest.class)
	public void ValidateSignOut( HashMap<String,String> input) {
		
		 landingPage.login(input.get("email"), input.get("password"));
		 signOutPage.signOut();
		
	    Assert.assertTrue(signOutPage.isLoginPageVisible(), "Sign-out failed — login email input not visible.");
	    System.out.println("Successfully signed out!");
	}

		
	}
		
		
		
