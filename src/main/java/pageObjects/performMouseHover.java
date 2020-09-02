package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class performMouseHover {
	public WebDriver driver;
	By myProfile = By.xpath("//*[contains(@aria-label,'My profile')]/div");

	public performMouseHover(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getHover() {
		return driver.findElement(myProfile);
	}

}
