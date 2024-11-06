package sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import sauceDemoPages.DashboardObjects;
import sauceDemoPages.LoginObjects;
import sauceDemoPages.MultipleTests;

public class SauceDemo {

	public static String browser; 
	private static WebDriver driver;
	
	
	@BeforeTest
	public static void setBrowserConfig() {
			
		PropertiesFile.readPropertiesFile();
		browser = PropertiesFile.getProperty("browser");
        System.out.println("Browser set in InvalidLogin: " + browser);
		
		if(browser.contains("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
	}
	
	@Test
	public static void InvalidLoginRunTest() {
		
		
		LoginObjects sauceDemoObj = new LoginObjects(driver);
		
		sauceDemoObj.EmailTextBox("standard_user");
		sauceDemoObj.PasswordTextBox("secret_sauc");
		sauceDemoObj.LoginButton();
		 
	}
	
	
	@Test
	public static void ValidLoginRunTest() {
		
		
		LoginObjects sauceDemoObj = new LoginObjects(driver);
		
		sauceDemoObj.EmailTextBox("standard_user");
		sauceDemoObj.PasswordTextBox("secret_sauce");
		sauceDemoObj.LoginButton();
		Multipletest();
		//Dashboard();
		
		 
	}
	
	public static void Dashboard() {
		
		DashboardObjects dashboardObj = new DashboardObjects(driver);
		dashboardObj.FilterDropDown();
		dashboardObj.AddToCart();
	}
	
	public static void Multipletest() {
		
		MultipleTests multipletestObj = new MultipleTests(driver);
		
		multipletestObj.selectmenu();
		multipletestObj.selectAbout();
		multipletestObj.contactus();
		multipletestObj.selectfacebookoption();
		
	}
	
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
		
	}

}



