package sauceDemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginObjects {
	
	
	WebDriver driver = null;
	By testbox_email = By.name("user-name");
	By testbox_password = By.name("password");
	By loginbutton = By.name("login-button");

	public LoginObjects(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public void EmailTextBox(String text) {
		
		driver.findElement(testbox_email).sendKeys(text);
		
	}
	
	public void PasswordTextBox(String text) {
		
		driver.findElement(testbox_password).sendKeys(text);
		
	}
	
	public void LoginButton() {
		
		driver.findElement(loginbutton).sendKeys(Keys.RETURN);
		
	}
}
