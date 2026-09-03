package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 
{

	public static void main(String[] args)
	{
		WebDriver driver =new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The Page Title is = " + driver.getTitle());
		WebElement checkBox=driver.findElement(By.xpath("//input[@id=\'checkbox\']"));
		checkBox.click();
		System.out.println(checkBox.isDisplayed());
		WebElement toggleBox=driver.findElement(By.xpath("//button[contains(text(),\'Toggle Checkbox\')]"));
		toggleBox.click();
		System.out.println(toggleBox.isDisplayed());
		driver.close();
		
	}
}
