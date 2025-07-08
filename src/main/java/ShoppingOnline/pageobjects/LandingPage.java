package ShoppingOnline.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	   }
	
	@FindBy(css="a[data-csa-c-content-id='nav_ya_signin']")
	WebElement HelloSignIn ;
	

	@FindBy(id="nav-flyout-ya-signin")
	WebElement flyoutSignIn ;
	
	
	@FindBy(css="input[autocomplete='username']")
    WebElement emailInput;
	
	@FindBy(css="input.a-button-input")
    WebElement continue_button;
	

	@FindBy(css="input[autocomplete='current-password']")
    WebElement passwordInput;
	

	@FindBy(css="input[class='a-button-input']")
    WebElement signIn_button;
	
	@FindBy(xpath="//div[@id='auth-error-message-box']//div[@class='a-alert-content']")
    WebElement invalidLoginText;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
    WebElement greetingText;
	
	//span[@id='nav-link-accountList-nav-line-1']
	
	public void goToLink() {
		
		driver.get("https://www.amazon.in/?ref_=nav_signin");
	}


	public void hoverAndClickSignIn() {
		
		 Actions a = new Actions(driver);
		 a.moveToElement(HelloSignIn).build().perform();
		 flyoutSignIn.click();
		}
	
    public void enterEmail(String email) {
		
		emailInput.sendKeys(email);
		continue_button.click();
		}
	
	public void enterPassword( String password) {
		 passwordInput.sendKeys(password);
		 signIn_button.click();
		    }

    public void login(String email, String password) {
	        hoverAndClickSignIn();
	        enterEmail(email);
	        enterPassword(password);
	    }
    
    public String InvalidLogin() {
    	
       WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
 	   wait.until(ExpectedConditions.visibilityOf(invalidLoginText));
        return invalidLoginText.getText();
 		
 	}

    public String validLogin() {
    	
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
  	   wait.until(ExpectedConditions.visibilityOf(greetingText));
         return greetingText.getText();
  		
  	}

	
}
