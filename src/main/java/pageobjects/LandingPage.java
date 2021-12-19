package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
		By signin=By.cssSelector("a[href*='sign_in']");
		By title=By.xpath("//div[@class=\'text-center\']/h2");
		By navbar=By.xpath("(//div/nav/ul)[2]");
	
	public LandingPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement logIn()
	{
		return driver.findElement(signin);
	}
	public WebElement gettitle()
	{
		return driver.findElement(title);
	}
	public WebElement getnavbar()
	{
		return driver.findElement(navbar);
	}
}
