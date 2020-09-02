package SeleniumAutomation.EndToEndProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources.BaseClass;

public class ValidatePageTitle extends BaseClass{
	public static Logger log = LogManager.getLogger(PhotographyPageTest.class.getName());
	
	@Test
	public void navigateToHomePage() throws IOException {
		driver = initializeDriver();
		String urlToFetch =prop.getProperty("URL");
		log.info("Opening URL..!");
		driver.get(urlToFetch);

	}
	
	@Test
	public void verifyTitle() throws IOException {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, prop.getProperty("URL"));

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed..!");
	}

}
