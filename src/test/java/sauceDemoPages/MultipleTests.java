package sauceDemoPages;




import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MultipleTests {
	
	WebDriver driver = null;
	
	By menuoption = By.id("react-burger-menu-btn");
	By about = By.id("about_sidebar_link");
	By contactus = By.cssSelector("a[href='/contact-us']");
	By email = By.id("Email");
	By company = By.id("Company");
	By intrest = By.id("Solution_Interest__c");
	By comments = By.id("Sales_Contact_Comments__c");
	By facebook = By.cssSelector("a[href*='facebook.com']");
	

	public MultipleTests(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void selectmenu() {
		
		driver.findElement(menuoption).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void selectAbout() {
		
		
		//Actions actions = new Actions(driver);
		driver.findElement(about).click();
		
		//actions.sendKeys(Keys.PAGE_DOWN).perform();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void contactus() {
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactus);
		 //select the contact us
		WebElement contact = driver.findElement(contactus);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		contact.click();
		driver.get("https://saucelabs.com/contact-us");
		
		//fill the form
		driver.findElement(email).sendKeys("abc@gmail.com");
		driver.findElement(company).sendKeys("abc");
		WebElement dropdown = driver.findElement(intrest);
		Select select = new Select(dropdown);
		select.selectByValue("Mobile Application Testing");
		driver.findElement(comments).sendKeys("This is a comment");
		
		//Go back
		driver.navigate().back();
	}
	
	public void selectfacebookoption() {
		
		//scroll down
		WebElement contactUs = driver.findElement(contactus); // Replace with your locator
		contactUs.sendKeys(Keys.PAGE_DOWN);
	
		//click Facebook option
		driver.findElement(facebook).click();
		String expectedUrl = "https://www.facebook.com/saucelabs/"; // Replace with the expected Facebook URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl, "The URL does not match the expected Facebook URL.");
		
	}
	
	

}
