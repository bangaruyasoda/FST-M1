package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity1 
{
	WebDriver driver;
	
	@BeforeClass	
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		
	}
	@Test(priority=0)
	public void pageTitleTest()
	{
		Assert.assertEquals(driver.getTitle(),"Training Support");
	}
	@Test(priority=1)
	public void buttonTest()
	{
		WebElement button= driver.findElement(By.xpath("//a[text()=\"About Us\"]"));
		button.click();
		
	}
	@Test(priority=2)
	public void newPageTitleTest() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"About Training Support");
	}
	
	@AfterClass
	public void closeTest()	
	{
		driver.close();
	} 

}




