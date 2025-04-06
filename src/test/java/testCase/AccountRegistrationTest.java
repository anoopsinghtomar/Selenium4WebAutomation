package testCase;

import org.testng.Assert;
import org.testng.annotations.*;
import com.github.javafaker.Faker;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testClass.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	@Test
	public void AccountRegistration() {
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegistratin();
		
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		
		logger.info("enter customer details");
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
		
		logger.info("account registered");
	}
	catch (Exception e) {
		logger.error("account registration failed");
		logger.debug("Debug logs...");
		Assert.fail();
	}
}
}