package testCase;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import testClass.BaseClass;

public class loginTest extends BaseClass {

	@Test
	public void verify_Login() {
		
		logger.info("*** starting login ***");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver); 
		lp.setEmail(properties.getProperty("email"));
		lp.setPassword(properties.getProperty("password"));
		lp.clickLogin();
		
		myAccountPage mya = new myAccountPage(driver);
		boolean targetPage = mya.isMyAccountDisplayed();
		
		Assert.assertEquals(targetPage, true,"Login Failed");
		
		logger.info("logged in successfully");
	}
}