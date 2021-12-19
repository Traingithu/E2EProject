package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class ValidateTitle extends Base {

	private static Logger Log = (Logger) LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initial() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));	
		Log.info("Driver Initialized & successfully landed on the App");
	}
	
	@Test
	public void pageNavigation() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		Assert.assertEquals(lp.gettitle().getText(), "FEATURED COUR212SES");
		Log.info("successfully text has been validated");
				
	}
	@AfterTest
		public void teardown()
	{
		driver.close();
	}
	
}
