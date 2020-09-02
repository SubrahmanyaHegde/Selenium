package SeleniumAutomation.EndToEndProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandOnLogin;
import pageObjects.PerformLogin;
import pageObjects.PerformLogout;
import resources.BaseClass;

public class PerformLogoutTest extends BaseClass {

	public static Logger log = LogManager.getLogger(PerformLogoutTest.class.getName());

	@BeforeTest

	public void initialize() throws IOException, InterruptedException {

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
	public void performLogin() throws IOException {
		PerformLogin loginPerform = new PerformLogin(driver);
		log.info("Entering user name...");
		loginPerform.getUserId().sendKeys(prop.getProperty("emailid"));
		loginPerform.getUserPwd().sendKeys(prop.getProperty("password"));
		log.info("Entered user pwd...");
		loginPerform.getSubmitButton().click();
		log.info("Clicked on submit button...");

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
