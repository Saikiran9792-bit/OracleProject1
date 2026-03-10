package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	static {
		try {
			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getURL() {
		return prop.getProperty("url");
	}

	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}

	public String getPersonNumber() {
		return prop.getProperty("personNumber");
	}

	public String getStartdate() {
		return prop.getProperty("startdate");
	}

	public String getEnddate() {
		return prop.getProperty("enddate");
	}

	public String getComments() {
		return prop.getProperty("comment");
	}

}
