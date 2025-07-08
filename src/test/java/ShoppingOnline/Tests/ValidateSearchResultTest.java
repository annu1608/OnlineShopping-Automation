package ShoppingOnline.Tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import ShoppingOnline.TestComponents.BaseTest;


public class ValidateSearchResultTest extends BaseTest{
	
	 @Test(dataProvider = "getData", groups={"SearchProduct"}, dataProviderClass = E_CommerceSoftcopyTest.class)
	    public void  ValidateSearchResult( HashMap<String,String> input) {
	
		   
	        
		    searchPage.searchProduct(input.get("categories"), input.get("searchBy"));
	        System.out.println("ActualProductName:  "+ searchingResultPage.validateProductName( input.get("desiredProduct")));
	        
	        String ActualProductName=  searchingResultPage.validateProductName( input.get("desiredProduct"));
	        Assert.assertNotNull(ActualProductName, "Desired product not found in search results!");
	        Assert.assertEquals(ActualProductName,  input.get("desiredProduct").trim(), "Product name does not match the expected product!");

	        
	    }

	
	
	
	}