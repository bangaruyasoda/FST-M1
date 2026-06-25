package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {

	public static void main(String[] args) 
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net");
		System.out.println("The Page title is " + driver.getTitle());
		WebElement ele= driver.findElement(By.linkText("About Us"));
		ele.click();
		System.out.println("The New Page title is " + driver.getTitle());
		driver.quit();

	}

}
