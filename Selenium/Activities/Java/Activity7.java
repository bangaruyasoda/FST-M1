package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println(driver.getTitle());
		WebElement inputBox=driver.findElement(By.xpath("//input[@id=\'textInput\']"));
		System.out.println(inputBox.isEnabled());
		WebElement Button = driver.findElement(By.id("textInputButton"));
		Button.click();
		System.out.println(inputBox.isEnabled());
		inputBox.sendKeys("Text is typed here");
		System.out.println(inputBox.getDomProperty("value"));
		driver.close();
	}
}



