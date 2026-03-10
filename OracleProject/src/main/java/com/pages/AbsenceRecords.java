package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ActionUtil;

public class AbsenceRecords {

	private WebDriver driver;

	private WebDriverWait wait;

	public AbsenceRecords(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	private By tasks = By.xpath("//img[@title='Tasks']");

	private By add = By.xpath("//span[text()='Add']");

	public void addAbsence() {

		wait.until(ExpectedConditions.elementToBeClickable(tasks));

		String Title = driver.getTitle();

		System.out.println(Title);
		
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertTrue(Title.contains("Absence Records - Person Management - Oracle Fusion Cloud Applications"));

		ActionUtil.click(driver, add, "AddAbsence_Button");

	}

}
