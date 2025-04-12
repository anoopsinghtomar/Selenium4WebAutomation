package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage {  
	
	public myAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//h2[text()='My Account']")
	WebElement msgHeading;
	
	public boolean isMyAccountDisplayed() {
		try {
			return msgHeading.isDisplayed();
		}
			catch(Exception e) {
				return false;
			}
	}
}