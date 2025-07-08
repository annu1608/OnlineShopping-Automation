package ShoppingOnline.pageobjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOutPage {

	WebDriver driver;

	public SignOutPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	   }
	
	@FindBy(id="nav-link-accountList")
	WebElement hover_NavLink;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement signOutButton;
	
	@FindBy(css="input[autocomplete='username']")
    WebElement againEmailInput;
	
	public void hoverNav() {
		 Actions a = new Actions(driver);
		a.moveToElement(hover_NavLink).perform();
		
	}
	public void signOutClick() {
	   signOutButton.click();
		
	}
	
	public void signOut() {
		hoverNav();
		signOutClick();
		
	}
	
	public boolean isLoginPageVisible() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(againEmailInput));
	        return againEmailInput.isDisplayed();
	}
	
}
	
	