package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	 public static void main(String[] args) {
	        // Setup WebDriverManager to manage the browser driver (Chrome in this case)
	        WebDriverManager.chromedriver().setup();
	        
	        // Create an instance of WebDriver (ChromeDriver)
	        WebDriver driver = new ChromeDriver();
	        
	        // Navigate to Google
	        driver.get("https://www.google.com");
	        
	        // Locate the Google search box using its 'name' attribute
	        WebElement searchBox = driver.findElement(By.name("q"));
	        
	        // Type a search term in the search box
	        searchBox.sendKeys("Selenium WebDriver");

	        // Submit the search form (or alternatively, send 'Keys.RETURN' as an ENTER equivalent)
	        searchBox.sendKeys(Keys.RETURN);
	        
	        // Add a small delay to observe the result (for demo purposes)
	        try {
	            Thread.sleep(2000);  // Wait for 2 seconds before closing the browser
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	        // Close the browser
	        driver.close();
	    }
}


/*  // Get the search button using the separate method and click it
        WebElement searchButton = getSearchButton(driver);
        searchButton.click();
      
        // Separate function to get the search button element
    public static WebElement getSearchButton(WebDriver driver) {
        // Locate the search button using its 'name' attribute
        return driver.findElement(By.name("btnK"));
    } */
