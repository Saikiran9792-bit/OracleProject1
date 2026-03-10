package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActionUtil {

	public static void click(WebDriver driver, By locator, String elementName) {

		// Take Screenshot BEFORE click
		Screenshotutils.capturePassedScreenshot(driver, elementName);

		WebElement element = driver.findElement(locator);
		element.click();
	}

	public static void clickFindBy(WebDriver driver, FindBy locator, String elementName) {

		// Take Screenshot BEFORE click
		Screenshotutils.capturePassedScreenshot(driver, elementName);

		WebElement element = driver.findElement((By) locator);
		element.click();
	}
}
