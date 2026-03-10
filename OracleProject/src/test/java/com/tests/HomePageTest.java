package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import utils.ConfigReader;

public class HomePageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyOracleLoginPage() {

		LoginPage loginPage = new LoginPage(driver);

		ConfigReader config = new ConfigReader();

		String username = config.getUsername();

		String password = config.getPassword();

		loginPage.loginToOracle(username, password);

	}

	@Test(priority = 2)
	public void verifyHomePage() {

		HomePage homePage = new HomePage(driver);

		homePage.navigateToMyClientGroups();

		homePage.openPersonManagement();
	}
}
