package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPageObjects {

	WebDriver driver = null;
	
	By testbox_search = By.name("q");
	
	public GoogleSearchPageObjects(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void setTextInSearchBox(String text) {
		
		driver.findElement(testbox_search).sendKeys(text);
		driver.findElement(testbox_search).sendKeys(Keys.RETURN);
	}

}
