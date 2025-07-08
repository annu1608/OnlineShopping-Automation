package ShoppingOnline.Tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class E_Commerce {
     public static void main(String[] args)throws InterruptedException {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
            WebDriver driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		        
	//link
	   	  driver.get("https://www.amazon.in/?ref_=nav_signin");
	   		    
		    
   //sign in account
	       Actions a = new Actions(driver);
		   a.moveToElement(driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_ya_signin']"))).build().perform();
		   driver.findElement(By.id("nav-flyout-ya-signin")).click();
	       driver.findElement(By.cssSelector("input[autocomplete='username']")).sendKeys("annu.crpf@gmail.com");
		   driver.findElement(By.cssSelector("input.a-button-input")).click();
		   driver.findElement(By.cssSelector("input[autocomplete='current-password']")).sendKeys("Annu@123");
		   driver.findElement(By.cssSelector("input[class='a-button-input']")).click();
		    
		
		    
   //search dropdown
			WebElement staticDropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByVisibleText("Baby");
			System.out.println("Product Categories: " +dropdown.getFirstSelectedOption().getText());
			
		
	//enter desired product
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby oil");
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    
	    //wait until show
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".puis-card-container.s-card-container ")));
    	
	    a.sendKeys(Keys.PAGE_DOWN).perform();
    	
	    List<WebElement> OilList= driver.findElements(By.cssSelector("div[data-cy='title-recipe']"));
     
	    String DesiredProductName = "Cetaphil Baby Massage Oil, 200 ml, White";
	    System.out.println("Required Product Name: " +DesiredProductName);   
	    
	    OilList.stream()
          .filter(BabyOil -> BabyOil.getText().trim().equalsIgnoreCase(DesiredProductName)) // Match exact product
          .findFirst() // Get first match
          .ifPresent(BabyOil -> {
                      wait.until(ExpectedConditions.elementToBeClickable(BabyOil)).click();    });
     
	      
   // window switch
	        Set <String> window=driver.getWindowHandles();
	        Iterator<String> it =window.iterator();
	        String parentId =it.next();
	        String childId= it.next();
	       // System.out.println(parentId);
	       // System.out.println(childId);
	        driver.switchTo().window(childId);
	        
	      
	      
   //quantity inc and add to cart
	        a.scrollByAmount(0,900).perform();
	        driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
	        driver.findElement(By.id("quantity_1")).click();
	        System.out.println( driver.findElement(By.xpath("//span[@class='a-button-inner']//child::span")).getText());
	        a.scrollByAmount(0,384).perform();
	        
	        Assert.assertEquals( driver.findElement(By.xpath("//span[@class='a-button-inner']//child::span")).getText(),"Quantity:2");
	        driver.findElement(By.cssSelector("input[aria-labelledby=\"submit.add-to-cart-announce\"]")).click();
	        driver.findElement(By.xpath("//a[@href='/cart?ref_=sw_gtc']")).click();
	     
	   
  // Get all cart items
	        String RequiredCartItem = "Cetaphil Baby Massage Oil, 200 ml, White";
	  	    
	        //list of cart item and size
	        List<WebElement> cartItems = driver.findElements(By.cssSelector("div[data-name='Active Items'] li a h4"));
            System.out.println("Total items in cart: " + cartItems.size());
            
  	        // Check if matching product exists
            boolean productFound = true;
             for (WebElement item : cartItems) {
                String itemText = item.getText().trim();
                System.out.println("Cart Required Item: " + itemText);
                
                if (itemText.equalsIgnoreCase(RequiredCartItem)) {
                    System.out.println("✅ Product is in the cart: " + itemText);
                    productFound = true;
                    break; }}
               
                        if (!productFound) {
                            System.out.println("Product not found in cart!"); }
                                                                           
   //signout
                        
            WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
            a.moveToElement(accountList).perform();
                
            driver.findElement(By.xpath("//span[text()='Sign Out']")).click();
            System.out.println("Successfully signed out!");

               
 	
		}}