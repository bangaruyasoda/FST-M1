package ProjectActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Activity3 extends Fixtures
{
	@Test
	public void pageCopyrightText()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Supercharged')]")));
		WebElement copyright= driver.findElement(By.xpath("//a[contains(text(),'Supercharged')]"));
		String textCopyright = copyright.getText();
		System.out.println(textCopyright);
	}
	

}
