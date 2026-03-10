package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutils {

	private static final String BASE_PATH = System.getProperty("user.dir") + File.separator + "Screenshots";

	// Capture PASSED screenshot

	public static void capturePassedScreenshot(WebDriver driver, String actionName) {

		captureScreenshot(driver, actionName, "Passed");
	}

	// Capture FAILED screenshot
	public static void captureFailedScreenshot(WebDriver driver, String actionName) {

		captureScreenshot(driver, actionName, "Failed");
	}

	// Common screenshot method

	private static void captureScreenshot(WebDriver driver, String actionName, String status) {

		try {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Create folder if not exists
			File folder = new File(BASE_PATH + File.separator + status);
			if (!folder.exists()) {
				folder.mkdirs();
			}

			File dest = new File(folder + File.separator + timestamp + "_" + actionName + ".png");

			FileUtils.copyFile(src, dest);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
