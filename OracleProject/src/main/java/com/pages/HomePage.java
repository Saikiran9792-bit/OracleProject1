package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ActionUtil;

public class HomePage {

	private WebDriver driver;

	private WebDriverWait wait;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	// Locators (update based on actual Oracle app)
	private By home = By.xpath("//a[@title='Home']");

	private By navigator = By.xpath("//a[@title='Navigator']");

	private By workforce = By.xpath("//div[@title='My Workforce']");

	private By personManagementLink = By.xpath("//span[text()='Person Management']");

	public void navigateToMyClientGroups() {

		String Title = driver.getTitle();

		System.out.println(Title);

		Assert.assertTrue(Title.contains("Welcome"));

		wait.until(ExpectedConditions.elementToBeClickable(home));

		ActionUtil.click(driver, home, "Home_Button");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(navigator));

		ActionUtil.click(driver, navigator, "navigator_Button");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.elementToBeClickable(workforce));

		ActionUtil.click(driver, workforce, "My workforce_Button");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void openPersonManagement() {

		wait.until(ExpectedConditions.elementToBeClickable(personManagementLink));

		ActionUtil.click(driver, personManagementLink, "personManagement_Button");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
