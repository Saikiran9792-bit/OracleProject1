package com.tests;

import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pages.AbsenceRecords;
import com.pages.AbsencesPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PersonManagementPage;

import utils.ConfigReader;

public class CreateAbsence extends BaseTest {

	@Test(priority = 1)
	public void verifyOracleLoginPage() {

		LoginPage loginPage = new LoginPage(driver);

		ConfigReader config = new ConfigReader();

		String username = config.getUsername();

		String password = config.getPassword();

		loginPage.loginToOracle(username, password);

	}

	@Test(priority = 2, enabled = true)
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

	@Test(priority = 4)
	public void verifyAbsenceRecordsPage() {

		AbsenceRecords absenceRecordsPage = new AbsenceRecords(driver);

		absenceRecordsPage.addAbsence();

	}

	@Test(priority = 5)
	public void verifyAbsencePage() {

		ConfigReader config = new ConfigReader();

		AbsencesPage absencePage = new AbsencesPage(driver);

		absencePage.absenceType();

		String startdate = config.getStartdate();

		String enddate = config.getEnddate();

		String comment = config.getComments();

		absencePage.enterStartdate(startdate, enddate, comment);

	}
}
