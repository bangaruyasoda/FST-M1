package Activity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity22 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/popups");
		System.out.println("The title of the page is = " +driver.getTitle());
		WebElement button = driver.findElement(By.id("launcher"));
		button.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
		WebElement user= driver.findElement(By.id("username"));
		WebElement pass= driver.findElement(By.id("password"));
		user.sendKeys("admin");
		pass.sendKeys("password");
		WebElement submit = driver.findElement(By.xpath("//button[text()=\"Submit\"]"));
		submit.click();
		Thread.sleep(5000);
		WebElement message = driver.findElement(By.xpath("//h1"));
        System.out.println("Login message: " + message.getText());
		driver.quit();	
	}

}
