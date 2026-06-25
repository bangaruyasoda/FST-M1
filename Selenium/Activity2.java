package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println("The Page title is " + driver.getTitle());
		WebElement user= driver.findElement(By.id("username"));
		user.sendKeys("admin");
		WebElement pass= driver.findElement(By.name("password"));
		pass.sendKeys("password");
		WebElement logButton= driver.findElement(By.xpath("//button[@class='svelte-1pdjkmx']"));
		logButton.click();
		System.out.println("The New Page title is " + driver.getTitle());
		driver.quit();

	}

}