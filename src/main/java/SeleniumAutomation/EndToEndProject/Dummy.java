package SeleniumAutomation.EndToEndProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dummy {

	public static void main(String[] args) throws IOException {
		 WebDriver driver;
		 Properties prop;

		prop = new Properties();
		FileInputStream input = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\EndToEndProject\\src\\main\\java\\resources\\constants.properties");
		prop.load(input);

		String browserName = prop.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("URL"));
			driver.findElement(By.xpath("//*[contains(@href,'login-popup')]")).click();
			driver.findElement(By.name("email")).sendKeys(prop.getProperty("emailid"));
			driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
			driver.findElement(By.name("submit")).click();
			Actions action = new Actions(driver);		
			WebElement target = driver.findElement(By.xpath(".//*[contains(@aria-label,'My profile')]/div"));
			action.moveToElement(target).perform();
			driver.findElement(By.xpath("//*[contains(text(),'Log out')]")).click();
			driver.close();
			
			

		}
	}

}
