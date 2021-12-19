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

public class ValidateDisplay extends Base {
	private static Logger Log = (Logger) LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initial() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		Log.info("Driver has been initialized");
		Log.info("Logged in to application");
	}
	@Test
	public void pageNavigation() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		Assert.assertTrue(lp.getnavbar().isDisplayed());
		Log.info("Navigation bar is successfully displayed");
		
	}
	@AfterTest
	public void teardown()
{
	driver.close();
}
	
}
