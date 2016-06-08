package seleniumAuto.seleniumAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonFile 
{
WebDriver wd ;
	public WebDriver retDriver()
	{
		wd = new FirefoxDriver() ;
		wd.get("https://login.salesforce.com") ;
	return wd ; 
	}
}
