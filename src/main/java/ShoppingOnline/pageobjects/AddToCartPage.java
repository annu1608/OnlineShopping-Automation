package ShoppingOnline.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

	WebDriver driver;

	Actions actions;
	
	
	public AddToCartPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	    this.actions = new Actions(driver);
	
	   }
	
	@FindBy(xpath="//span[@class='a-button-inner']//child::span")
	WebElement Quantityconfirmation;
	

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	

	@FindBy(xpath="//a[@href='/cart?ref_=sw_gtc']")
	WebElement goToCartLink;
	
	@FindBy(css="h1[class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")
	WebElement addtToCartText;
	
	
	
	public void scrollProductPage() {
		 actions.scrollByAmount(0,900).perform();
		
	}
	
	   public String getConfirmationText() {
	        return Quantityconfirmation.getText();
	    }
	
	
	public void clickAddToCart() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		    wait.until(ExpectedConditions.visibilityOf(addToCartButton));
		    wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
	    }

	
 
    public void goToCart() {
	        //actions.scrollByAmount(0, 200).perform();
	        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.elementToBeClickable(goToCartLink)).click();
	       // goToCartLink.click();
	    }
    
public String confirmationAddingCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.visibilityOf(addtToCartText));
	return addtToCartText.getText();
}
    
}