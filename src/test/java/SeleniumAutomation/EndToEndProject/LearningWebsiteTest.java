package SeleniumAutomation.EndToEndProject;

import java.io.IOException;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandOnLogin;
import pageObjects.MyCourseList;
import pageObjects.PerformLogin;
import pageObjects.PerformLogout;
import pageObjects.performMouseHover;
import resources.BaseClass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LearningWebsiteTest extends BaseClass {

	public static Logger log = LogManager.getLogger(LearningWebsiteTest.class
			.getName());

	@BeforeTest
	public void navigateToHomePage() throws IOException {
		driver = initializeDriver();
		String urlToFetch = prop.getProperty("URL");
		log.info("Opening URL..!");
		driver.get(urlToFetch);

	}

	@Test(priority = 0)
	public void clickOnLogin() throws IOException {
		LandOnLogin login = new LandOnLogin(driver);
		log.info("Opening login page..!");
		login.getLogin().click();

	}

	@Test(priority = 1)
	public void performLogin() throws IOException, InterruptedException {
		PerformLogin loginPerform = new PerformLogin(driver);
		log.info("Entering user name...");
		loginPerform.getUserId().sendKeys(prop.getProperty("emailid"));
		log.info("Entering user pwd...");
		loginPerform.getUserPwd().sendKeys(prop.getProperty("password"));
		log.info("Clicking on submit button...");
		loginPerform.getSubmitButton().click();
	}
	
	@Test(priority = 2)
	public void navigateToMyCourses() throws IOException, InterruptedException {
		MyCourseList myCourses = new MyCourseList(driver);
		log.info("Clicking on My Courses option...");
		myCourses.getMyCourses().click();
	}


	@Test(priority = 3)
	public void performHover() throws IOException, InterruptedException {
		log.info("Hovering on My Profile..!");
		performMouseHover hoverPerform = new performMouseHover(driver);
		Actions action = new Actions(driver);
		Action hover = action.moveToElement(hoverPerform.getHover()).build();
		hover.perform();
		//Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void performLogout() throws IOException {
		PerformLogout logoutPerform = new PerformLogout(driver);
		logoutPerform.getLogout().click();
		log.info("Logged out successfully..!");

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed..!");
	}

}
