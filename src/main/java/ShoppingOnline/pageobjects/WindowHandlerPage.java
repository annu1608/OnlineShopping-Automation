package ShoppingOnline.pageobjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandlerPage {

	WebDriver driver;
	
	public WindowHandlerPage(WebDriver driver)
	   {
		this.driver= driver;
		}
	
	
	public void switchToChildWindow() {
		
		
		    String parentWindow = driver.getWindowHandle();
		    Set<String> allWindows = driver.getWindowHandles();
		    
		    for (String windowHandle : allWindows) {
		        if (!windowHandle.equals(parentWindow)) {
		            driver.switchTo().window(windowHandle);
		           
		            break;
		        }
		    }
		}
	
	

	
	
}
