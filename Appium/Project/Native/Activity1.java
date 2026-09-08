package nativeapplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 
{
	AppiumDriver driver;
	WebDriverWait wait;
	
	@Test
	public void setUp() throws MalformedURLException, URISyntaxException
	{
		//File object for the application
		File testApp = new File("src/test/resources/ToDo.apk");
		//set the desired capabilities or options
		UiAutomator2Options options= new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp(testApp.getAbsolutePath());
		options.setAppPackage("com.android.home");
		options.setAppActivity("com.google.android.apps.Chrome.Main");
		
		
		options.noReset();
		
		//Initialize the object
		
		URL serverUrl = new URI("http://localhost:4723").toURL();
		driver = new AndroidDriver(serverUrl,options);		
	}

    @Test
    public void createTasksAndVerify() throws InterruptedException {

        addTask("Complete Activity 1", "1", "Wednesday");

        addTask("Complete Activity 2", "2", "Wednesday");

        addTask("Complete Activity 3", "3", "Thursday");

        // Assertions
        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[@text='Complete Activity 1']"))
                        .isDisplayed(),
                "Activity 1 not found");

        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[@text='Complete Activity 2']"))
                        .isDisplayed(),
                "Activity 2 not found");

        Assert.assertTrue(
                driver.findElement(
                        By.xpath("//*[@text='Complete Activity 3']"))
                        .isDisplayed(),
                "Activity 3 not found");
    }

    private void addTask(String taskName,
                         String priority,
                         String dueDay) throws InterruptedException {

        // Click New button
        driver.findElement(By.id("com.example.todo:id/btnNew")).click();

        // Task name
        driver.findElement(By.id("com.example.todo:id/taskName"))
                .sendKeys(taskName);

        // Priority
        driver.findElement(By.id("com.example.todo:id/priority"))
                .click();

        driver.findElement(
                By.xpath("//*[@text='" + priority + "']"))
                .click();

        // Due date
        driver.findElement(By.id("com.example.todo:id/dueDate"))
                .click();

        driver.findElement(
                By.xpath("//*[@text='" + dueDay + "']"))
                .click();

        // Save task
        driver.findElement(By.xpath("//*[@text='OK']")).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}