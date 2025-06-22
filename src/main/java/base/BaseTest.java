package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.internal.LogManagerStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import utils.ExtentReportManager;
import utils.Log;

public class BaseTest {
	
	protected WebDriver driver;
	protected static ExtentReports extent;
	protected ExtentTest test;
	
	
	@BeforeSuite
	public void setupReport() {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@AfterSuite
	public void teardownReport() {
		extent.flush();
		String reportPath = ExtentReportManager.reportPath;
		//EmailUtils.sendTestReport(reportPath);
	}
	
	@BeforeMethod
	public void setUp(Method method) {
		
		
		
		Log.info("Starting WebDriver...");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1750, 768));
		Log.info("Navigating to URL...");
			
		driver.get("https://hmarkets.com/");
	}
	
	
	

	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		
		
		
		if(result.getStatus() == ITestResult.FAILURE) {
			
			String screenshotPath = ExtentReportManager.captureScreenshot(driver, "Demo Registration Failure");
			test.fail("Test Failed.. Check Screenshot", 
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.log(Status.FAIL, "Test case failed is: " + result.getName());
			test.log(Status.FAIL, "Test case failed is: " + result.getMethod());
			test.log(Status.FAIL, "Test case failed is: " + result.getThrowable());
			
		}
		
		
		if (driver != null) {
			Log.info("Closing Browser...");
			driver.quit();
		}
	}
	
	
	

}
