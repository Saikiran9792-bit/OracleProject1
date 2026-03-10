package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.base.BaseTest;
import com.driver.DriverManager;

import utils.Screenshotutils;

public class IListeners extends BaseTest implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = DriverManager.getDriver();
		String testName = result.getName();

		Screenshotutils.captureFailedScreenshot(driver, testName);

		System.out.println("Screenshot captured for failed test: " + testName);
	}

	@AfterTest
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
	}

	@BeforeSuite
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started");
	}

	@AfterSuite
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished");
	}
}
