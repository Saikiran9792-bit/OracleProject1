package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ActionUtil;

public class AbsencesPage {

	private WebDriver driver;

	private WebDriverWait wait;

	public AbsencesPage(WebDriver driver) {
		this.driver = driver;

		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	private By absencetype = By.xpath("(//label[text()='Absence Type'])[1]/following::a[1]");

	private By annualLeave = By.xpath("//li[text()='Annual Leave']");

	private By startDate = By.xpath("//input[@aria-label='Start Date']");

	private By endDate = By.xpath("//input[@aria-label='End Date']");

	private By comments = By.xpath("//label[contains(text(),'Comments')]/following::textarea");

	public void absenceType() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionUtil.click(driver, absencetype, "absencetype_Button");

		wait.until(ExpectedConditions.elementToBeClickable(annualLeave));

		ActionUtil.click(driver, annualLeave, "annualLeave_Button");

		wait.until(ExpectedConditions.elementToBeClickable(startDate));

	}

	public void enterStartdate(String startdate, String enddate, String comment) {

		driver.findElement(startDate).sendKeys(startdate);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		clickcomments(enddate, comment);
	}

	public void clickcomments(String enddate, String comment) {

		driver.findElement(comments).sendKeys(comment);

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Enddate = driver.findElement(endDate);

		Enddate.clear();

		Enddate.sendKeys(enddate);

		enterEnddate(enddate);
	}

	public void enterEnddate(String enddate) {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Enddate = driver.findElement(endDate);

		Enddate.clear();

		Enddate.sendKeys(enddate);

		driver.findElement(comments).click();

		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionUtil.click(driver, endDate, "Enter Absence Record");
	}
}
