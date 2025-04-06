package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public static WebDriver driver;

	@BeforeClass
	public void initializeDriver() {

		// Set the path to chromedriver.exe if not using WebDriverManager
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		// Avoid devtools websocket if not needed
		options.addArguments("--disable-save-password-bubble");
		options.addArguments("credentials_enable_service=false");
		options.addArguments("profile.password_manager_enabled=false");
		options.addArguments("disable-notifications");
		options.addArguments("disable-infobars");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		// Navigate to the application using the URL from Config.java
		driver.get(Config.BASE_URL); // Use the URL from Config class
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}
