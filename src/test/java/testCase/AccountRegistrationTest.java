package testCase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import baseTest.BaseClass;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationTest {
	
	public WebDriver driver;
	
	/*
	 * public AccountRegistrationTest(WebDriver driver) { super(driver); }
	 */	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void AccountRegistration() {
		
		Faker faker = new Faker();
		String password = faker.internet().password(5, 8, true);
				
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegistratin();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		regPage.setFirstName(faker.name().firstName());
		regPage.setLastName(faker.name().lastName());
		regPage.setEmail(faker.internet().emailAddress());
		regPage.setTelephone(faker.phoneNumber().cellPhone());
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickContinue();
		
		String conmsg = regPage.getConfirmationMsg();
		Assert.assertEquals(conmsg, "Your Account Has Been Created!");
	}
	
	@AfterTest
	public void tearDown() {
		 if (driver != null) {
	            driver.quit(); }
	}
}