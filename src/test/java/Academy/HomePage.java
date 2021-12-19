package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	private static Logger Log = (Logger) LogManager.getLogger(Base.class.getName());
	public WebDriver driver;

	@BeforeTest
	public void initial() throws IOException {
		driver = initializeDriver();
		Log.info("Driver has been initialized");

	}

	@Test(dataProvider = "getData")
	public void pageNavigation(String Username, String Password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.logIn().click();
		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(Username);
		l.getPassword().sendKeys(Password);
		l.getLogin().click();
		Log.info(text);

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12387";
		data[0][2] = "Restricted User";

		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "12387";
		data[1][2] = "non Restricted User";

		return data;

	}
}
