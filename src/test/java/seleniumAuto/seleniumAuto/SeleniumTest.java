package seleniumAuto.seleniumAuto;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class SeleniumTest 
{
CommonFile cf ;
WebDriver wd ; 
WebDriverWait wait ;
Boolean isPresent ; 
@Test
	public void testCases()
    {
     cf = new CommonFile() ;
     wd = cf.retDriver() ;
wd.findElement(By.xpath("//input[@id='username']")).sendKeys("amarjeet_parmar@optum.stitch.qa"); ;
wd.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd1237!"); 
wd.findElement(By.xpath("//input[@id='Login']")).click();
wait = new WebDriverWait(wd, 30);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='userNav-arrow']")));
wd.findElement(By.xpath("//div[@id='userNav-arrow']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Setup')]"))) ;
wd.findElement(By.xpath("//a[contains(text(),'Setup')]")).click() ;
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Expand - Manage Users - Level 1']"))) ;
wd.findElement(By.xpath("//img[@title='Expand - Manage Users - Level 1']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ManageUsers_font']"))) ;
wd.findElement(By.xpath("//a[@id='ManageUsers_font']")).click() ;
wd.findElement(By.xpath("//a[@title='Login - Record 20 - User3, Test3']")).click();
wd.findElement(By.xpath("//a[contains(text(),'Providers')]")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'HICKS, ANNA')]"))) ;
wd.findElement(By.xpath("//a[contains(text(),'HICKS, ANNA')]")).click();
isPresent = wd.findElements(By.xpath("//input[@title='New Credentialing']")).size() > 0  ;
System.out.println(isPresent); 
Assert.assertEquals(false,isPresent) ;
     
    }
}
