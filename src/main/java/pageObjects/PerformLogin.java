package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PerformLogin {
	public WebDriver driver;
	By userId = By.name("email");
	By pwd = By.name("password");
	By submit = By.name("submit");

	public PerformLogin(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUserId() {
		return driver.findElement(userId);
	}

	public WebElement getUserPwd() {
		return driver.findElement(pwd);
	}

	public WebElement getSubmitButton() {
		return driver.findElement(submit);
	}

}
