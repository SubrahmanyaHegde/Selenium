package SeleniumAutomation.EndToEndProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandOnLogin;
import pageObjects.PerformLogin;
import resources.BaseClass;

public class PerformLoginTest extends BaseClass {
	public static Logger log = LogManager.getLogger(PerformLoginTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
	}

	@Test
	public void clickOnLogin() throws IOException {
		LandOnLogin login = new LandOnLogin(driver);
		log.info("Opening login page..!");
		login.getLogin().click();
	}

	@Test
	public void performLogin() throws IOException, InterruptedException {
		PerformLogin loginPerform = new PerformLogin(driver);
		log.info("Entering user name...");
		loginPerform.getUserId().sendKeys(prop.getProperty("emailid"));
		log.info("Entering user pwd...");
		loginPerform.getUserPwd().sendKeys(prop.getProperty("password"));
		log.info("Clicking on submit button...");
		loginPerform.getSubmitButton().click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed..!");
	}

}
