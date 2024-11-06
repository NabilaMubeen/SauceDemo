package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.io.InputStream;
import java.io.OutputStream;

public class PropertiesFile {

	//Create object for properties class
	static Properties prop = new Properties();
	public static void main(String[] args) {
		readPropertiesFile();
		
		
		
	}

	public static void readPropertiesFile() {
		
		
		//Create an object for inputstream
		try {
			InputStream input = new FileInputStream("C:\\Users\\nabila.mubeen_ventur\\eclipse-workspace\\Selenium.maven.demo\\src\\test\\java\\Config\\config.properties");
		
			//load the properties file
			prop.load(input);
			
			//Get properties
			/*System.out.println(prop.getProperty("browser"));
			FirstSeleniumTest.browser = prop.getProperty("browser");
			InvalidLogin.browser = prop.getProperty("browser");*/
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static String getProperty(String key) {
        return prop.getProperty(key);
    }
	
	
	public static void writePropertiesFile() {
		//Create an object for outpustream
		try {
			OutputStream output = new FileOutputStream("C:\\\\Users\\\\nabila.mubeen_ventur\\\\eclipse-workspace\\\\Selenium.maven.demo\\\\src\\\\test\\\\java\\\\Config\\\\config.properties");
			prop.setProperty("browser", "Chrome");
			prop.store(output, null);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
