package testClass;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.github.javafaker.Faker;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	
	public Faker faker = new Faker();
	public String password = faker.internet().password(5, 8, true);
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
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