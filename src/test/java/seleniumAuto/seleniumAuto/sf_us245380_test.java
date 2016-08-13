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
import org.openqa.selenium.support.ui.WebDriverWait;


public class sf_us245380_test
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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='userNav-arrow']")));
		wd.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Setup']"))) ;	 
		wd.findElement(By.xpath("//a[@title='Setup']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Expand - Manage Users - Level 1']"))) ;
		wd.findElement(By.xpath("//img[@title='Expand - Manage Users - Level 1']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ManageUsers_font' and text()='Users']"))) ;
		wd.findElement(By.xpath("//a[@id='ManageUsers_font' and text()='Users']")).click() ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Login - Record 21 - User2, Test2' and text()='Login']"))) ;
		wd.findElement(By.xpath("//a[@title='Login - Record 21 - User2, Test2' and text()='Login']")).click() ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='allTabsArrow']"))) ;
		wd.findElement(By.xpath("//img[@class='allTabsArrow']")).click() ;
		/*Data SetUp*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//a[contains(.,'INR Contracts')]"))) ;
		wd.findElement(By.xpath("//tr//a[contains(.,'INR Contracts')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='New']"))) ;
		wd.findElement(By.xpath("//input[@title='New']")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Name' and @tabindex='1']"))) ;
		wd.findElement(By.xpath("//input[@id='Name' and @tabindex='1']")).sendKeys("Temp INR Contract") ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Provider Lookup (New Window)']")));
		parentWindowHandler = wd.getWindowHandle() ;
		wd.findElement(By.xpath("//a[@title='Provider Lookup (New Window)']")).click() ;
		
		handles = wd.getWindowHandles() ;
		iterator = handles.iterator();
		System.out.println("Main window" + parentWindowHandler);
        handles.remove(parentWindowHandler) ;
        subWindowHandler = iterator.next() ;
		System.out.println("subwindow" + subWindowHandler);
		wd.switchTo().window(subWindowHandler) ;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='ANNA HICKS']"))) ;
wd.findElement(By.xpath("//a[text()='ANNA HICKS']")).click() ;
wd.switchTo().window(parentWindowHandler) ;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@id='bottomButtonRow']/input[@type='submit' and @value=' Save ']"))) ;
		wd.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@type='submit' and @value=' Save ']")).click() ;
		/*Data SetUp*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='allTabsArrow']"))) ;
		wd.findElement(By.xpath("//img[@class='allTabsArrow']")).click() ;
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//a[contains(.,'Contract Terminations')]"))) ;
		wd.findElement(By.xpath("//tr//a[contains(.,'Contract Terminations')]")).click();
		/*Data SetUp*/
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=' New ']"))) ;
		wd.findElement(By.xpath("//input[@value=' New ']")).click();
		
		
		/*Data SetUp End */
		Assert.fail("I am failure") ;
	}
	
}