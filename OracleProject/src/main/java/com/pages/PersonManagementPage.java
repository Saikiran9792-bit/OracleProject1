package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ActionUtil;

public class PersonManagementPage {

	private WebDriver driver;

	private WebDriverWait wait;

	public PersonManagementPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(xpath = "//input[contains(@aria-label,'Person Number')]")
	WebElement personNumberInput;

	@FindBy(xpath = "//button[contains(@id,'search')]")
	WebElement searchButton;

	@FindBy(xpath = "//span[text()='Name']/following::div/table/tbody/tr/td[2]/div/table/tbody/tr")
	WebElement selectName;

	private By Actions = By.xpath("//a[text()='Actions']");

	private By Absences = By.xpath("//td[text()='Absences']");

	private By absenceRecords = By.xpath("//td[text()='Absence Records']");

	public void searchPerson(String personNumber) {

		wait.until(ExpectedConditions.visibilityOf(personNumberInput));
		personNumberInput.clear();
		personNumberInput.sendKeys(personNumber);

		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();

		String Title = driver.getTitle();

		System.out.println(Title);

		Assert.assertTrue(Title.contains("Search Person - Person Management - Oracle Fusion Cloud Applications"));

		wait.until(ExpectedConditions.visibilityOf(selectName));
		selectName.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions();
	}

	public void actions() {
		wait.until(ExpectedConditions.elementToBeClickable(Actions));
		ActionUtil.click(driver, Actions, "absenceRecords_Button");
		absences();
	}

	public void absences() {
		wait.until(ExpectedConditions.elementToBeClickable(Absences));
		ActionUtil.click(driver, Absences, "absenceRecords_Button");
		absenceRecords();
	}

	public void absenceRecords() {
		wait.until(ExpectedConditions.elementToBeClickable(absenceRecords));
		ActionUtil.click(driver, absenceRecords, "absenceRecords_Button");
	}
}
