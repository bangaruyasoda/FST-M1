package ProjectActivity;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class Activity6 extends Fixtures
	{

		    @Test
	    public void verifyActivitiesMenuExistsAndClickable() 
		    {

	        // Login
	        driver.findElement(By.id("user_name"))
	                .sendKeys("admin");

	        driver.findElement(By.id("username_password"))
	                .sendKeys("pa$$w0rd");

	        driver.findElement(By.id("bigbutton"))
	                .click();

	        // Locate Activities menu
	        WebElement activitiesMenu = driver.findElement(
	                By.xpath("//a[contains(text(),'Activities')]"));

	        // Verify menu exists
	        Assert.assertTrue(activitiesMenu.isDisplayed(),
	                "Activities menu is not displayed");

	        // Click Activities menu
	        activitiesMenu.click();

	        System.out.println("Activities menu exists and is clickable.");
	    }

	 }


