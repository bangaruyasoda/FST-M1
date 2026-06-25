package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		System.out.println("The Page Title is = " + driver.getTitle());
		WebElement user = driver.findElement(By.xpath("//input[@id=\'username\']"));
		WebElement pass = driver.findElement(By.xpath("//input[@id=\'password\']"));
		user.sendKeys("admin");
		pass.sendKeys("password");
		WebElement button = driver.findElement(By.xpath("//button[@class=\'svelte-1pdjkmx\']"));
		button.click();
		System.out.println("The New Page Title is = " +driver.getTitle());
		driver.close();
	}

}
