package com.seasonalloan.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import com.seasonalloan.dataprovider.ConfigFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dorothy.Kisormoi
 *
 */
public class BaseClass {

	static ConfigFileReader readconfig = new ConfigFileReader();

	public static WebDriver driver;
	public static Properties prop;
	public static Logger Logger;
	public static String baseUrl = readconfig.getApplicationURL();
	public String browser = readconfig.getBrowser();

	@SuppressWarnings("deprecation")
	@BeforeTest

	public static void launchBrowser(String browser) {

// Add Logs to test
		Logger = LogManager.getLogger(BaseClass.class);

		// Select browser depending on the setup in properties file data and
		// initialize/launch browser
		if (browser.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		Logger.info("Browser is initialized");

		// Maximize browser
		driver.manage().window().maximize();

		// Delete cookies
		driver.manage().deleteAllCookies();

		// Tells the webdriver to wait for a certain amount of time before throwing No
		// element exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter application url
		driver.get(baseUrl);
		Logger.info("url entered");
	}

	@AfterClass
	public void closeBrowser() {
//Close the browser after test
		driver.quit();
	}
}
