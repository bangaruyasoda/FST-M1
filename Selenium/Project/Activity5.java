package ProjectActivity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Getting colors
//Goal: Get the color of the navigation menu
//Open a browser.
//Navigate to ‘https://crm.alchemy.hguy.co’ and login using the credentials provided.


public class Activity5 extends Fixtures
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
	public void pageTitleTest() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "SuiteCRM", "Homepage is NOT opened");
		System.out.println("Home Page is opened");
		
	}
}
