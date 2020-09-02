package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformLogout  {

	WebDriver driver;
	By myAccount = By.xpath("//*[@id='u213-popover-trigger--25']/div");
	By logOut = By.xpath("//*[contains(text(),'Log out')]");
	By logOutOptions = By.id("header-profile-menu");
	By signOut = By.xpath("//*[contains(text(),'Sign out')]");

	public PerformLogout(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getMyAccount() {
		return driver.findElement(myAccount);
	}

	public WebElement getLogout() {
		return driver.findElement(logOut);
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getSignOutOptions() {
		return driver.findElement(logOutOptions);
	}
	
	public WebElement getSignOut(){
		return driver.findElement(signOut);
	}
}
