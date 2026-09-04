package ProjectActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Activity2 extends Fixtures
{
	@Test
	public void pageURLTest() throws InterruptedException
	{
		Thread.sleep(1000);
		WebElement urlHeader = driver.findElement(By.xpath("//img"));
		String srcUrl= urlHeader.getAttribute("src");
		System.out.println("Hello");
        System.out.println(srcUrl);
		
	}	

}
