package ShoppingOnline.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

	WebDriver driver;

	public CartPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	   }
	
	@FindBy(css="div[data-name='Active Items'] li a h4")
	List<WebElement> CartItemTitle;
	
	
	
	public int getCartItemCount() {
		return CartItemTitle.size();
		   }
	
	public List<WebElement> getCartItems() {
		return CartItemTitle;
	     }
	
	public boolean  isProductInCart(String RequiredCartItem) {
		 
		      for (WebElement item : getCartItems()) {
		         String itemText = item.getText().trim();
		         
		         
		         if (itemText.equalsIgnoreCase(RequiredCartItem)) {
		        	 return true;
		        	 
		         }
		        }
		        return false;
		    }
	}
	
	 