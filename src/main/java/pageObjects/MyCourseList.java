package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyCourseList {
	public WebDriver driver;
	By myCourse = By.xpath("//*[contains(text(),'My courses')]");

	public MyCourseList(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getMyCourses() {
		return driver.findElement(myCourse);
	}

}
