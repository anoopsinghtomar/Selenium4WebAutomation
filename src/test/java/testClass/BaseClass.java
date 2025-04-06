package testClass;

import java.time.Duration;

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
	
	public Faker faker = new Faker();
	public String password = faker.internet().password(5, 8, true);
	
	@BeforeTest
	@Parameters({"os","browser"})
	public void setup(String os, String browser) {
		
		switch(browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("invalid browser"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(this.getClass()); // logging test script
	}
	
	@AfterTest
	public void tearDown() {
		 if (driver != null) {
	            driver.quit(); }
	}	
}