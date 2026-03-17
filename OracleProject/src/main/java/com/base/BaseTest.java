package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.pdfUtil;
import com.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	protected String imageFolderPath = System.getProperty("user.dir") + "/Screenshots/Passed";
	

	@BeforeTest
	public void setup() {

		ConfigReader config = new ConfigReader();

		String browser = config.getBrowser();

		String url = config.getURL();

		// Launch browser based on config value
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

		} else {

			System.out.println("Browser not supported");

		}

		DriverManager.setDriver(driver);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Open URL
		driver.get(url);
	}

	@AfterTest
	public void tearDown() {
		DriverManager.getDriver().quit();
		DriverManager.unload();
	}

	@AfterSuite
	public void generatePDFReport() throws Exception {
		String outputPath = System.getProperty("user.dir") + "/Screenshots/Create Absence/TestExecutionReport.pdf";
		
		
		pdfUtil.generatePDF(imageFolderPath, outputPath);
//		result.getTestClass().getRealClass().getSimpleName();

	}
}
