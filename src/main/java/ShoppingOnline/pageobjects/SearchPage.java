package ShoppingOnline.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	   {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	   }
	

    @FindBy(xpath = "//select[@id='searchDropdownBox']")
    WebElement categoryDropdown;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchInput;

    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

	
    
    
    public String selectCategory(String category) {
    	WebElement staticDropdown =categoryDropdown;
    	Select dropdown = new Select(staticDropdown);
    	dropdown.selectByVisibleText(category);
    	return dropdown.getFirstSelectedOption().getText();
}
    
   public void enterProductName(String ProductName) {
	   searchInput.sendKeys(ProductName);
	    }
   
   public void clickSearchButton() {
	   searchButton.click();  
	    }

   
   public void searchProduct(String category,String ProductName) {
	   selectCategory(category);
	   enterProductName(ProductName);
	   clickSearchButton() ;
   }
   
   
}
