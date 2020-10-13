package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream input = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\constants.properties");
		prop.load(input);

		//String browserName = prop.getProperty("Browser");
		String browserName = System.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					prop.getProperty("ChromeDriverPath"));
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver(options);

		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",
					prop.getProperty("IEDriverPath"));
			driver = new InternetExplorerDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String getScreenshot(String TestCaseName, WebDriver driver)
			throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir") + "\\reports\\"
				+ TestCaseName + ".png";
		FileUtils.copyFile(srcFile, new File(destFile));
		return destFile;
	}

}
