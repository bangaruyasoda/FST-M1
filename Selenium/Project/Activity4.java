package ProjectActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity4 extends Fixtures
{
	@BeforeClass
	public void loginURL() throws InterruptedException
	{
		Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        WebElement userField= driver.findElement(By.xpath("//input[contains(@name,\"user\")]"));
		WebElement pass= driver.findElement(By.xpath("//input[@name=\"password\"]"));			
		userField.sendKeys("admin");
		pass.sendKeys("5Nx#I6BK%r3$8vz0ch");
		WebElement loginButton = driver.findElement(By.xpath("//button[@id=\'login-button\']"));
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		loginButton.click();
		System.out.println("Login is clicked");
	}
	@Test
		public void pageCopyrightText() throws InterruptedException
		{		
			Thread.sleep(1000);
			Assert.assertEquals(driver.getTitle(), "SuiteCRM", "Homepage is NOT opened");
			System.out.println("Home Page is opened");	
			
		}
		
	}



