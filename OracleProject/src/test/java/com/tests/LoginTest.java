package com.tests;

import com.base.BaseTest;
import org.testng.annotations.Test;
import com.pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

	@Test
	public void verifyOracleLoginPage() {

		LoginPage loginPage = new LoginPage(driver);

		ConfigReader config = new ConfigReader();

		String username = config.getUsername();

		String password = config.getPassword();

		loginPage.loginToOracle(username, password);

	}

}
