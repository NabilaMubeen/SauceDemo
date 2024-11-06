package Test;

import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import pages.GoogleSearchPageObjects;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class FirstSeleniumTest {
	
	public static String browser; 
	private static WebDriver driver;
	private static ExtentReports extent;
    private static ExtentTest test;
	

	@BeforeTest
	public static void setBrowserConfig() {
		
		 // Set up Extent Reports
        ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
			
		PropertiesFile.readPropertiesFile();
		browser = PropertiesFile.getProperty("browser");
        System.out.println("Browser set in FirstSeleniumTest: " + browser);
		
		if(browser.contains("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
	}
	
	@Test
	public static void runTest() {
		
		test = extent.createTest("Google Search Test", "Sample test to demonstrate ExtentReports with TestNG");
		
		GoogleSearchPageObjects searchPageObj = new  GoogleSearchPageObjects(driver);
		
		test.info("Navigating to Google");
		driver.get("https://google.com/");
		
		test.info("Entering search term");
		searchPageObj.setTextInSearchBox("selenium testing");
		
		  try {
			  
			  	test.info("Waiting for results to load");
	            Thread.sleep(2000);  // Wait for 2 seconds before closing the browser
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  
		
		
	}
	
	@AfterTest
	public void TearDown() {
		
		test.info("Closing the browser");
		driver.close();
		
		// Flush the extent report
        extent.flush();
		
	}

}
