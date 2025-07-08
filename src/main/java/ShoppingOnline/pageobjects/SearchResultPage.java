package ShoppingOnline.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {

	WebDriver driver;

	 
	public SearchResultPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
		 
	   }
	
	@FindBy(css=".puis-card-container.s-card-container ")
	WebElement Resultcontainer;
	
	public
	@FindBy(css="div[data-cy='title-recipe']")
	List<WebElement> articleList;
	

	
	
   public void waitForResultToLoad() {
	   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(Resultcontainer));
   }

   public void scrollDownSearchPage() {
	   Actions a = new Actions(driver);
       a.sendKeys(Keys.PAGE_DOWN).perform();
   }

   public void clickDesiredProduct(String desiredProductName  ) {
	   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
       
	 
	   
	    articleList.stream()
       .filter(article -> article.getText().trim().equalsIgnoreCase(desiredProductName)) // Match exact product
       .findFirst() // Get first match
       .ifPresent(article -> {
                   wait.until(ExpectedConditions.elementToBeClickable(article)).click();    });
                    }
   
   
   public void findAndClickProduct(String  desiredProductName) {
	   waitForResultToLoad() ;
	   scrollDownSearchPage();
       clickDesiredProduct( desiredProductName);
   }

   

   public String validateProductName(String  desiredProductName) {
	   WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	   waitForResultToLoad() ;

	    return articleList.stream()
	            .filter(article -> article.getText().trim().equalsIgnoreCase(desiredProductName))
	            .findFirst()
	            .map(article -> {
	                wait.until(ExpectedConditions.elementToBeClickable(article));
	                return article.getText();
	            })
	            .orElse("Product not found");
               
   }




}