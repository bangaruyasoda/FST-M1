package Activity;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {

	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice");
		System.out.println("The Page Title is = " +driver.getTitle());
		WebElement ele1 = driver.findElement(By.xpath("//h3[contains(text(),'Heading #3')]"));
		System.out.println(ele1.getText());
		WebElement ele2 = driver.findElement(By.xpath("//h5[contains(text(),'Heading #5')]"));
		System.out.println(ele2.getCssValue("color"));
		String purpleButton= driver.findElement(By.xpath("//button[text()=\'Purple\']")).getDomAttribute("class");
		System.out.println("The class of Purple button is =" + purpleButton);
		WebElement ele3= driver.findElement(By.xpath("//button[text()=\'Slate\']"));
		System.out.println("The text of the Slate Button is = " +ele3.getText());
		driver.close();
	}

}
