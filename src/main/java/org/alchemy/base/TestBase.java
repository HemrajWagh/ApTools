package org.alchemy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class TestBase {
	
	
	
	
	public static WebDriver driver;
	public static Properties prop;
	public TestBase()
	{
		prop = new Properties();
		try {
			FileInputStream fis = new  FileInputStream("D:\\hemraj\\InstallSoft\\eclipse-workspace\\ApTools\\src"
					+ "\\main\\java\\org\\alchemy\\config\\Config.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
	}
	
	public void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette", "./Driver/geckodriver1.exe");
			WebDriver driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("applicationUrl"));
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml1.html");
		ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			ExtentTest logger = extent.createTest(driver.getTitle());
			logger.log(Status.PASS, driver.getTitle()+ "PassedTest");
			extent.flush();

	}
	
	public void ExReport()
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/ExtentHtml1.html");
		ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			ExtentTest logger = extent.createTest(driver.getTitle());
			logger.log(Status.PASS, driver.getTitle()+ "PassedTest");
			extent.flush();
	}
	

}
