package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PersonManagementPage;

import utils.ConfigReader;

public class ValidatePersonManagementPage extends BaseTest {

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

	@Test(priority = 3)
	public void verifyPersonManagementPage() {

		ConfigReader config = new ConfigReader();

		PersonManagementPage personPage = new PersonManagementPage(driver);

		String personNumber = config.getPersonNumber();

		personPage.searchPerson(personNumber);
	}

}
