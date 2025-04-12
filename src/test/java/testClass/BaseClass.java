package testClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties properties;
	
	public Faker faker = new Faker();
	public String password = faker.internet().password(5, 8, true);
	
	/*
	 * static ResourceBundle getURL() { //method to access config.propertiles FILE
	 * ResourceBundle api = ResourceBundle.getBundle("config"); return api; }
	 * 
	 * String appUrl = getURL().getString("appURL");
	 */
		
	@BeforeTest
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws IOException{
		
		//Loading config.properties file
		FileReader file = new FileReader("src/test/resources/config.properties");
		properties = new Properties();
		properties.load(file);
		
		switch(browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("invalid browser"); return;
		}
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("appURL"));
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(this.getClass()); // logging test script
	}
	
	@AfterTest
	public void tearDown() {
		 if (driver != null) {
	            driver.quit(); }
	}	
}