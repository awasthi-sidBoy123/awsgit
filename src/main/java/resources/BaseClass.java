package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public static WebDriver getTypeOfBrowser() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\ApiAutomation\\src\\main\\java\\resources\\url.properties");
        prop.load(fis);
        
        String selectedBrowser = prop.getProperty("browser");
        
        if(selectedBrowser.contains("chrome")) {
        	System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        	ChromeOptions options = new ChromeOptions();
        	if (selectedBrowser.contains("headless")) {
        		options.addArguments("headless");
        	}
        	driver = new ChromeDriver();
        	return driver;
        	
        }else if(selectedBrowser.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver", "D:\\driver\\geckodriver.exe");
        	driver = new FirefoxDriver();
        	return driver;
        	
        }else {
        	
        }
		return driver;
	}
	
	

}
