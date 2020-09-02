package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandOnLogin {
	public WebDriver driver;
	By signIn = By.xpath("//*[contains(@href,'login-popup')]");
	By googleLink = By.xpath("//*[@data-purpose='google-link']");

	public LandOnLogin(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getLogin() {
		return driver.findElement(signIn);
	}
	
	public WebElement getGoogleLink()
	{
		return driver.findElement(googleLink);
	}

}
