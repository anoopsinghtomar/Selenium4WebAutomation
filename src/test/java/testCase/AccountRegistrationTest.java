package testCase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationTest extends BaseClass {
	
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
}