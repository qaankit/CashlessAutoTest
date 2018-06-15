package com.auto.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.auto.configProperties.ConfigProperties;


public class TestCore extends Page {

	static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
	static Date date = new Date();
	public static Properties object = new Properties();
	public static Properties config = new Properties();
	public static WebDriver driver;
	public static String SCREENSHOT_FOLDER = "target/screenshots/";
	public static final String SCREENSHOT_FORMAT = ".png";
	private String testUrl;
	private String targetBrowser;
	private String os;
	private String crossBrowser;

	@BeforeTest(alwaysRun = true)
	public void fetchSuiteConfiguration(ITestContext testContext) {

		try {

		} catch (Exception e) {
		}

		testUrl = ConfigProperties.site_url;
		System.out.println("----------" + testUrl + "----------");
		targetBrowser = ConfigProperties.browser_name;
		os = ConfigProperties.OS;
	}

	/**
	 * WebDriver initialization
	 * 
	 * @return WebDriver object
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@BeforeMethod(alwaysRun = true)
	public void setup(Method method) throws IOException, InterruptedException {
		if (crossBrowser.toLowerCase().equals("local")) {

			if (os.toLowerCase().equals("windows")) {
				if (targetBrowser.toLowerCase().contains("firefox") || targetBrowser.toLowerCase().contains("ff")) {
					System.setProperty("webdriver.gecko.driver",
							System.getProperty("user.dir") + "//src//main//resources//driver_windows//geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
				} else if (targetBrowser.toLowerCase().contains("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
							+ "//src//main//resources//driver_windows//chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}

				else if (targetBrowser.toLowerCase().contains("IE") || targetBrowser.toLowerCase().contains("ie")) {
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")
							+ "//src//main//resources//driver_windows//IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
				}

			}

		}

		// Open test url
		driver.get(testUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		log("--------------------------------------------------------", ILogLevel.TESTCASE);
		log("Test [" + method.getName() + "] Started", ILogLevel.TESTCASE);
		log("--------------------------------------------------------", ILogLevel.TESTCASE);

	}

	/**
	 * capture screenshot on test(pass/fail)
	 * @throws InterruptedException 
	 * 
	 * 
	 */

	@AfterMethod(alwaysRun=true)
	public void setScreenshot(ITestResult result) throws InterruptedException {

		if (!result.isSuccess()) {
			try {
				if (driver != null) {
					File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					try {
						FileUtils.copyFile(f,
								new File(SCREENSHOT_FOLDER + result.getName() + SCREENSHOT_FORMAT).getAbsoluteFile());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			} catch (ScreenshotException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (driver != null) {

			driver.quit();
			
			/*if(l!=null){
				l.stop();
			}*/
		}

	}
	

}
