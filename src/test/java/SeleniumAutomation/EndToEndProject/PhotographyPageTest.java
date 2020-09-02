package SeleniumAutomation.EndToEndProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhotographyPageTest extends BaseClass {

	public static Logger log = LogManager.getLogger(PhotographyPageTest.class.getName());

	@BeforeTest

	public Properties loadProperties() throws IOException {

		FileInputStream inputFile = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\EndToEndProject\\src\\main\\java\\resources\\constants.properties");
		Properties property = new Properties();
		property.load(inputFile);
		log.info("Property file loaded sucessfully...!");
		return property;
	}

	@Test
	public void navigateToHomePage() throws IOException {
		driver = initializeDriver();
		String urlToFetch = loadProperties().getProperty("URL");
		log.info("Opening URL..!");
		driver.get(urlToFetch);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
		log.info("Browser closed..!");
	}

}
