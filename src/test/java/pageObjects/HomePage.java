package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testClass.BaseClass;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver); 
		}

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
	WebElement linkMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement linkRegistration;
	
	@FindBy(linkText="Login")
	WebElement linkLogin;
	
	public void clickMyAccount() {
		linkMyAccount.click(); 
	}
	
	public void clickRegistratin() {
		linkRegistration.click();
	}
	
	public void clickLogin() {
		linkLogin.click();
	}
}