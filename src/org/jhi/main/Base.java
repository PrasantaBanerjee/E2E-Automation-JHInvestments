package org.jhi.main;

import java.util.concurrent.TimeUnit;

import org.jhi.testcases.Validations_AboutUs;
import org.jhi.testcases.Validations_Homepage;
import org.jhi.testcases.Validations_Viewpoints;
import org.jhi.utils.PropertyFileReader;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * @author: Prasanta.
 * @desc:   This class should be extended by other classes to use the WebDriver instance.
 * 
 */

public class Base {
	static WebDriver driver;
	static PropertyFileReader config = new PropertyFileReader();
	static String browserName = config.getProperty("browsername");
	static String headless = config.getProperty("headless");
	static String appUrl = "https://" + config.getProperty("prod.url");
	static Validations_Homepage homepage = new Validations_Homepage();
	static Validations_Viewpoints viewpoints = new Validations_Viewpoints();
	static Validations_AboutUs aboutus = new Validations_AboutUs();
	
	//This method will close all browser/webdriver instances before launching new WebDriver instance.  
	public static void killAllBrowserInstances() {	
		if(browserName.equalsIgnoreCase("Chrome")) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			} catch(Exception e) {
				System.out.println("Exception occured: " + e.getMessage());
			}
		} else if(browserName.equalsIgnoreCase("Firefox")) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
				Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
			} catch(Exception e) {
				System.out.println("Exception occured: " + e.getMessage());
			}
		} else if (browserName.equalsIgnoreCase("IE")) {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			} catch(Exception e) {
				System.out.println("Exception occured: " + e.getMessage());
			}
		} 
	}

	//This method will create WebDriver instance & can be re-used by other classes by extending the class.
	public static WebDriver getDriver() {
		if(driver==null) {
			killAllBrowserInstances();
			if(browserName.equalsIgnoreCase("Chrome")) {
				launchChromeBrowser();
			} else if(browserName.equalsIgnoreCase("Firefox")) {
				launchFirefoxBrowser();
			} else if (browserName.equalsIgnoreCase("IE")) {
				launchIEBrowser();
			} else {
				throw new IllegalArgumentException(browserName + " browser is not supported.");
			}
			return driver;
		} else {
			return driver;
		}
	}

	//This method will launch the Chrome browser based on the config setup.
	public static void launchChromeBrowser() {
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + config.getProperty("chromedriver.path"));
		System.setProperty("webdriver.chrome.silentOutput", "true");	//to suppress chromedriver logs.
		ChromeOptions options = new ChromeOptions();
		if(headless.equalsIgnoreCase("Yes")) {
			options.addArguments("--headless");
			System.out.println("Launched " + browserName + " in Headless Mode.");
		} else {
			System.out.println("Launched " + browserName + " browser.");
		}
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	//This method will launch the Firefox browser based on the config setup.
	public static void launchFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir") + config.getProperty("geckodriver.path"));
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");	//to suppress geckodriver logs.
		FirefoxOptions options = new FirefoxOptions();
		if(headless.equalsIgnoreCase("Yes")) {
			options.addArguments("--headless");
			System.out.println("Launched " + browserName + " in Headless Mode.");
		} else {
			System.out.println("Launched " + browserName + " browser.");
		}
		driver = new FirefoxDriver(options);
	}
	
	//This method will launch the IE browser based on the config setup.
	public static void launchIEBrowser() {
		System.setProperty("webdriver.ie.driver" , System.getProperty("user.dir") + config.getProperty("iedriver.path"));
		driver = new InternetExplorerDriver();
		System.out.println("Launched " + browserName + " browser.");
	}

	//This method will close the WebDriver instance.
	public static void closeBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}

	@BeforeTest(alwaysRun=true)
	public static void launchApplication() {
		try {
			getDriver().get(appUrl);
			getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			System.out.println("Timeout Exception occured: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unknown Exception occured: " + e.getMessage());
		}
	}

	@AfterTest(alwaysRun=true)
	public void endBrowser() {
		closeBrowser();
	}

	@Test(groups= {"smoke", "regression"})
	public void TC1_Validate_HomepageUrl() {
		homepage.TC1_validateHomepageUrl();
	}

	@Test(groups = {"smoke", "regression"})
	public void TC2_Validate_HomepageTitle() {
		homepage.TC2_validateHomepageTitle();
	}

	@Test(groups = {"sanity", "regression"})
	public void TC3_Validate_NavigationMenuOptions() {
		homepage.TC3_validateNavigationMenuOptions();
	}
	
	@Test(groups = {"sanity", "regression"})
	public void TC4_Validate_ViewpointTitles() {
		viewpoints.clickAndVerifyViewpointLinks();
	}
	
	@Test(groups = {"sanity", "regression"})
	public void TC5_Validate_SocialMediaLinks() {
		aboutus.validateSocialMediaLinks();
	}
}