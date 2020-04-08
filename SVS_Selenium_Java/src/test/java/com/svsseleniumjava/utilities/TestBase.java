package com.svsseleniumjava.utilities;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

	public WebDriver driver;
	public Utilities utility = new Utilities();

	String driverPathChrome = utility.getPropertyValue("driverPathChrome");
	String driverPathFireFox = utility.getPropertyValue("driverPathFirefox");
	String driverPathIE = utility.getPropertyValue("driverPathIE");
	String browserName = "";

	String gURL = utility.getPropertyValue("appURL");
	// @BeforeSuite --> write something to verify later.

	// Browser launching
	@BeforeClass
	public void setUpAndInitialization() {
		browserName = utility.getPropertyValue("browserName");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			appURL(gURL);
			// driver.get(gURL);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
//			driver.manage().deleteAllCookies();
		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", driverPathFireFox);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			// driver.get(gURL);
			appURL(gURL);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
			driver.manage().deleteAllCookies();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", driverPathIE);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			appURL(gURL);
			// driver.get(gURL);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.MILLISECONDS);
			driver.manage().deleteAllCookies();
		}

	}

	public String appURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}
