package SeleniumAutomation.EndToEndProject;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandOnLogin;
import pageObjects.PerformLogin;
import pageObjects.PerformLogout;
import resources.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhotographyLearningPageTest extends BaseClass {

	public static Logger log = LogManager
			.getLogger(PhotographyLearningPageTest.class.getName());

	@BeforeTest
	public void navigateToHomePage() throws IOException {
		driver = initializeDriver();
		String urlToFetch = prop.getProperty("URL");
		log.info("Opening URL..!");
		driver.get(urlToFetch);

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

	@Test
	public void performLogout() throws IOException {
		PerformLogout logoutPerform = new PerformLogout(driver);
		logoutPerform.getMyAccount().click();
		log.info("Navigated to My Account...");
		logoutPerform.getLogout().click();
		log.info("Logged out successfully..!");

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed..!");
	}

}
