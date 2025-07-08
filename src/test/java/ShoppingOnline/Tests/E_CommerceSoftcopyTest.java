package ShoppingOnline.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ShoppingOnline.TestComponents.BaseTest;


public class E_CommerceSoftcopyTest extends BaseTest{
	
	
	
   @Test(dataProvider = "getData",dataProviderClass = E_CommerceSoftcopyTest.class)
   public void E_CommerceSoftcop( HashMap<String,String> input){
	   	  
	   	 
	     	
	        landingPage.login(input.get("email"), input.get("password"));
	        searchPage.searchProduct(input.get("categories"), input.get("searchBy"));
	        System.out.println("Product Categories: "+ searchPage.selectCategory(input.get("categories") ));
	      
            System.out.println("Desired Product Name: " +  input.get("desiredProduct"));
	        searchingResultPage.findAndClickProduct( input.get("desiredProduct"));
	        
	        windowHandlerPage.switchToChildWindow();
	        addToCartPage.scrollProductPage();
	        
	        System.out.println(addToCartPage.getConfirmationText());
	        addToCartPage.clickAddToCart();
	        addToCartPage.goToCart();
	        
	        System.out.println("Total items in cart: " + cartPage.getCartItemCount());
	        
	
	        if (cartPage.isProductInCart(input.get("RequiredCartItem"))) {
	            System.out.println("✅ Product is in the cart: " + input.get("RequiredCartItem"));
	        } else {
	            System.out.println("❌ Product not found in cart!");
	        }

	        signOutPage.signOut();
	        System.out.println("Successfully signed out!");
	       
	    }
	          
   
   
   
   
   @DataProvider(name = "getData")
   public static Object[][] getData() throws IOException 
      {

	   List<HashMap<String,String>> data = getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ShoppingOnline\\data\\buyItem.json");
       return new Object[][] { { data.get(0)} } ;
   }


   

   @DataProvider(name = "getInvalidLoginData")
   public static Object[][] loginData() throws IOException {
       List<HashMap<String,String>> data = getJsonToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ShoppingOnline\\data\\buyItem.json");
       
       return new Object[][] { { data.get(1) } }; // ✅ only login credentials
   }
  

}







