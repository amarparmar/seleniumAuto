package seleniumAuto.seleniumAuto;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class sf_tc42935
{
	WebDriver wd ;
	String url = "https://login.salesforce.com" ;
	WebDriverWait wait ;
	String parentWindowHandler ;
	String subWindowHandler ;
	Set<String> handles ;
	Iterator<String> iterator ;
	
	@Before
	public void setUp()
	{
		wd = new FirefoxDriver() ;
		wait = new WebDriverWait(wd, 50) ;
		wd.get(url);
		wd.manage().window().maximize();
		wd.findElement(By.xpath("//input[@name='username']")).sendKeys("amarjeet_parmar@optum.stitch.qa") ;
        wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd1237!");
        wd.findElement(By.xpath("//input[@id='Login']")).click() ;
	}
	@Test
	public void runTest()
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='allTabsArrow']"))) ;
		wd.findElement(By.xpath("//img[@class='allTabsArrow']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/img[@title='Credentialings']"))) ;
		wd.findElement(By.xpath("//a/img[@title='Credentialings']")).click() ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='credentialing for ana']"))) ;
		wd.findElement(By.xpath("//a[text()='credentialing for ana']")).click() ;
		boolean exists = wd.getPageSource().contains("Credentialing Status") ;
 		Assert.assertEquals(true,exists);
	}
	
}