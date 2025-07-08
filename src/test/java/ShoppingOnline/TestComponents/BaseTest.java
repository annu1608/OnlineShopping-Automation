package ShoppingOnline.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import ShoppingOnline.pageobjects.AddToCartPage;
import ShoppingOnline.pageobjects.CartPage;
import ShoppingOnline.pageobjects.LandingPage;
import ShoppingOnline.pageobjects.SearchPage;
import ShoppingOnline.pageobjects.SearchResultPage;
import ShoppingOnline.pageobjects.SignOutPage;
import ShoppingOnline.pageobjects.WindowHandlerPage;

public class BaseTest {
     public WebDriver driver;
     public LandingPage landingPage;
     public SearchPage searchPage;
     public SearchResultPage searchingResultPage;
     public WindowHandlerPage windowHandlerPage;
     public AddToCartPage addToCartPage;
     public CartPage cartPage ;
     public SignOutPage signOutPage;
     
    
     
	public WebDriver  initializerDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ShoppingOnline\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome")){
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
	                + "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
	        driver = new ChromeDriver(options); // ✅ Correctly assign to class-level driver
	    }
		driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   
        
	    return driver;
	    
	}
   
	
	 public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
			FileUtils.copyFile(source, file);
			return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
			
			
	    }
			
	
	
	
	public static  List<HashMap<String, String>> getJsonToMap(String filePath) throws IOException
	{
	    String jsonContent= FileUtils.readFileToString(new File(filePath),
				StandardCharsets.UTF_8);
	    
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){
		});
		
		
	return data;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public List<Object> launchApplication() throws IOException {
		
		driver=initializerDriver();
		
		
		
		  landingPage= new LandingPage(driver);
		  landingPage.goToLink();
		  searchPage = new SearchPage(driver);
	      searchingResultPage = new SearchResultPage(driver);
		  windowHandlerPage = new WindowHandlerPage(driver);
		  addToCartPage = new AddToCartPage(driver);
		  cartPage = new CartPage(driver);
		  signOutPage = new SignOutPage(driver);
		 
		  return Arrays.asList(landingPage,searchPage,searchingResultPage,windowHandlerPage,
				  addToCartPage,addToCartPage,cartPage,signOutPage);
		
	}
	
	

   @AfterMethod(alwaysRun=true)
   public void tearDown() {
	  
		 driver.close();
		 }
	

}
