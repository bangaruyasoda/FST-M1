package Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {
	public static void main(String[] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		System.out.println("The Page Title is = " + driver.getTitle());
		WebElement checkBox=driver.findElement(By.xpath("//input[@id=\'checkbox\']"));
		System.out.println(checkBox.isSelected());
		checkBox.click();
		if(checkBox.isSelected()==true)
		{
			System.out.println("Checkbox is Selected");
		}		
		driver.close();
	}

}
