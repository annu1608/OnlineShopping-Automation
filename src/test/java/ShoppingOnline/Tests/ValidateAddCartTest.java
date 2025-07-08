package ShoppingOnline.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import ShoppingOnline.TestComponents.BaseTest;


public class ValidateAddCartTest extends BaseTest{
	
	 @Test(dataProvider = "getData",groups={"Results"}, dataProviderClass = E_CommerceSoftcopyTest.class)
	    public void testClickAddToCart( HashMap<String,String> input) {
		 
		

		    searchPage.searchProduct(input.get("categories"), input.get("searchBy"));
		    searchingResultPage.findAndClickProduct(  input.get("desiredProduct"));
		    windowHandlerPage.switchToChildWindow();
	        addToCartPage.clickAddToCart();
	        
	       
	        String confirmationText = addToCartPage.confirmationAddingCart();
	        
	        System.out.println(">>> Confirmation Text: " + confirmationText);
	        Assert.assertTrue(confirmationText.equalsIgnoreCase("Added to Cart"), "Product was not added to the cart successfully!");
	    }
	



}