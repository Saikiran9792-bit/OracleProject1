package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionUtil;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Locators (update based on actual Oracle app)
	private By username = By.id("userid");
	private By password = By.id("password");
	private By loginBtn = By.id("btnActive");

	public void enterUsername(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		enterPassword(pass);
	}

	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
		clickLogin();
	}

	public void clickLogin() {
		ActionUtil.click(driver, loginBtn, "Login_Button");
	}

	public void loginToOracle(String user, String pass) {
		enterUsername(user, pass);
	}
}
